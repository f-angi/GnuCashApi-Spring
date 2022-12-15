package party.fangi.gnucashapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import party.fangi.gnucashapi.model.Expense;
import party.fangi.gnucashapi.persistence.model.Splits;
import party.fangi.gnucashapi.persistence.model.Transactions;
import party.fangi.gnucashapi.persistence.repository.TransactionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensesService {

    @Value("${app.default.page.size}")
    private int defaultPageSize;

    @Value("${app.default.sort.field}")
    private String defaultSortField;

    private final TransactionRepository transactionRepository;

    @Transactional
    public List<Expense> getExpensesByDescription(String description) {
        List<Transactions> transactionsList = transactionRepository.findByDescriptionContainingIgnoreCase(description);
        return transactionsList.stream().map(this::mapTransactionsToExpense).toList();
    }

    @Transactional
    public Page<Expense> getExpensesPaginated(int page) {
        return getExpenses(page, defaultPageSize, defaultSortField);
    }

    @Transactional
    public Page<Expense> getExpensesPaginated(int page, int size, String sortKey) {
        return getExpenses(page, size, sortKey);
    }

    @Transactional
    public Page<Expense> getExpensesPaginated(int page, int size) {
        return getExpenses(page, size, defaultSortField);
    }

    private Page<Expense> getExpenses(int page, int size, String sortKey) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortKey).ascending());
        Page<Transactions> transactionsPage = transactionRepository.findAll(pageRequest);
        return transactionsPage.map(this::mapTransactionsToExpense);
    }

    private Expense mapTransactionsToExpense(Transactions t) {
        Expense expense = new Expense();
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