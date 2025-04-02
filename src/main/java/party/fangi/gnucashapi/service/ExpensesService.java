package party.fangi.gnucashapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import party.fangi.gnucashapi.model.Expense;
import party.fangi.gnucashapi.model.Sort;
import party.fangi.gnucashapi.model.TransactionType;
import party.fangi.gnucashapi.persistence.model.Splits;
import party.fangi.gnucashapi.persistence.model.Transactions;
import party.fangi.gnucashapi.persistence.repository.AccountRepository;
import party.fangi.gnucashapi.persistence.repository.SplitRepository;
import party.fangi.gnucashapi.persistence.repository.TransactionRepository;
import party.fangi.gnucashapi.util.PageRequestHelper;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpensesService {

    @Value("${application.pagination.page.size}")
    private int defaultPageSize;

    @Value("${application.pagination.sort.field}")
    private String defaultSortField;

    @Value("${application.pagination.sort.direction}")
    private String defaultSortDirection;

    @Value("${application.currency-guid}")
    private String currencyGuid;

    private final TransactionRepository transactionRepository;
    private final SplitRepository splitRepository;
    private final AccountRepository accountRepository;
    private final PageRequestHelper pageRequestHelper;

    @Transactional
    public Page<Expense> getExpensesByDescriptionAndAccountName(String description, String accountName, TransactionType type) {
        Sort sort = Sort.builder()
                .pageNumber(0)
                .pageSize(defaultPageSize)
                .sortField(defaultSortField)
                .sortDirection(Direction.fromString(defaultSortDirection))
                .build();

        return getExpensesByDescriptionAndAccountNameAndSort(description, accountName, type, sort);
    }

    @Transactional
    public Page<Expense> getExpensesByDescriptionAndAccountNameAndSort(String description, String accountName, TransactionType type, Sort sort) {
        return getExpenses(description, accountName, type, sort);
    }

    @Transactional
    public Transactions createTransaction(LocalDate date, String description, String accountFrom, String accountTo, float amount) {
        Transactions transaction = new Transactions();
        transaction.setGuid(createGuid());
        transaction.setCurrencyGuid(currencyGuid);
        transaction.setPostDate(Timestamp.valueOf(date.atStartOfDay()));
        transaction.setEnterDate(Timestamp.valueOf(LocalDateTime.now()));
        transaction.setDescription(description);
        transaction.setNum("");
        Transactions saved = transactionRepository.save(transaction);

        Splits splitFrom = createSplit(transaction, accountFrom, -amount);
        Splits splitTo = createSplit(transaction, accountTo, amount);
        splitRepository.save(splitFrom);
        splitRepository.save(splitTo);

        return saved;
    }

    private Page<Expense> getExpenses(String description, String accountName, TransactionType type, Sort sort) {
        PageRequest pageRequest = pageRequestHelper.mapSearchToPageRequest(sort);

        Page<Transactions> transactionsPage = switch (type) {
            case EXPENSE -> transactionRepository.findExpenseTransactions(
                    StringUtils.hasText(description) ? description : null,
                    StringUtils.hasText(accountName) ? accountName : null,
                    pageRequest);
            case INCOME -> transactionRepository.findIncomeTransactions(
                    StringUtils.hasText(description) ? description : null,
                    StringUtils.hasText(accountName) ? accountName : null,
                    pageRequest);
            default -> transactionRepository.findTransactions(
                    StringUtils.hasText(description) ? description : null,
                    StringUtils.hasText(accountName) ? accountName : null,
                    pageRequest
            );
        };

        return transactionsPage.map(this::mapTransactionsToExpense);
    }

    private Expense mapTransactionsToExpense(Transactions t) {
        Expense expense = new Expense();
        expense.setId(t.getGuid());
        expense.setDescription(t.getDescription());
        expense.setDate(t.getEnterDate().toLocalDateTime().toLocalDate());
        for (Splits splits : t.getSplit()) {
            if (splits.getValueNum() > 0) {
                expense.setAccountTo(splits.getAccount().getName());
                expense.setAmount(splits.getValueNum() / 100f);
            } else {
                expense.setAccountFrom(splits.getAccount().getName());
            }
        }
        return expense;
    }

    private Splits createSplit(Transactions transaction, String account, float amount) {
        Splits split = new Splits();
        split.setGuid(createGuid());
        split.setTransaction(transaction);
        split.setAccount(accountRepository.findFirstByNameIgnoreCase(account).orElseThrow());
        split.setValueNum((long)(amount * 100));
        split.setValueDenom(100);
        split.setQuantityNum((long)(amount * 100));
        split.setQuantityDenom(100);
        split.setMemo("");
        split.setAction("");
        split.setReconcileState("n");
        return split;
    }

    private String createGuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
