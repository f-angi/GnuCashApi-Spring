package party.fangi.gnucashapi.service;

import lombok.RequiredArgsConstructor;
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

    private final TransactionRepository transactionRepository;
    private final PageRequestHelper pageRequestHelper;

    @Transactional
    public Page<Expense> getExpensesByDescription(String description, Sort sort) {
        PageRequest pageRequest = pageRequestHelper.mapSearchToPageRequest(sort);

        Page<Transactions> transactionsPage;
        if (StringUtils.hasText(description)) {
            transactionsPage = transactionRepository.findByDescriptionContainingIgnoreCase(description, pageRequest);
        }
        else {
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
                expense.setAccountTo(splits.getAccount().getDescription());
                expense.setAmount(splits.getValueNum() / 100f);
            } else {
                expense.setAccountFrom(splits.getAccount().getDescription());
            }
        }
        return expense;
    }
}