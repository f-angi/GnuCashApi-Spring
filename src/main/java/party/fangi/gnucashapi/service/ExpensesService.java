package party.fangi.gnucashapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import party.fangi.gnucashapi.model.Expense;
import party.fangi.gnucashapi.model.Sort;
import party.fangi.gnucashapi.persistence.model.Splits;
import party.fangi.gnucashapi.persistence.model.Transactions;
import party.fangi.gnucashapi.persistence.repository.TransactionRepository;
import party.fangi.gnucashapi.util.PageRequestHelper;

@Service
@RequiredArgsConstructor
public class ExpensesService {

    @Value("${pagination.page.size}")
    private int defaultPageSize;

    @Value("${pagination.sort.field}")
    private String defaultSortField;

    @Value("${pagination.sort.direction}")
    private String defaultSortDirection;

    private final TransactionRepository transactionRepository;
    private final PageRequestHelper pageRequestHelper;

    @Transactional
    public Page<Expense> getExpensesByDescriptionAndAccountName(String description, String accountName) {
        Sort sort = Sort.builder()
                .pageNumber(0)
                .pageSize(defaultPageSize)
                .sortField(defaultSortField)
                .sortDirection(defaultSortDirection)
                .build();

        return getExpenses(description, accountName, sort);
    }

    @Transactional
    public Page<Expense> getExpensesByDescriptionAndAccountNameAndSort(String description, String accountName, Sort sort) {
        return getExpenses(description, accountName, sort);
    }

    private Page<Expense> getExpenses(String description, String accountName, Sort sort) {
        PageRequest pageRequest = pageRequestHelper.mapSearchToPageRequest(sort);

        Page<Transactions> transactionsPage;
        if (StringUtils.hasText(description) && StringUtils.hasText(accountName)) {
            transactionsPage = transactionRepository.findByDescriptionContainingIgnoreCaseAndSplitAccountNameContainingIgnoreCase(description, accountName, pageRequest);
        } else if (StringUtils.hasText(description)) {
            transactionsPage = transactionRepository.findByDescriptionContainingIgnoreCase(description, pageRequest);
        } else if (StringUtils.hasText(accountName)) {
            transactionsPage = transactionRepository.findBySplitAccountNameContainingIgnoreCase(accountName, pageRequest);
        } else {
            transactionsPage = transactionRepository.findAll(pageRequest);
        }

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
}