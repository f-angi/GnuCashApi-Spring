package party.fangi.gnucashapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import party.fangi.gnucashapi.model.Expense;
import party.fangi.gnucashapi.persistence.model.Splits;
import party.fangi.gnucashapi.persistence.model.Transactions;
import party.fangi.gnucashapi.persistence.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensesService {

    private final TransactionRepository transactionRepository;

    @Transactional
    public List<Expense> getTransactionsByDescription(String description) {
        List<Transactions> transactionsList = transactionRepository.findByDescriptionContainingIgnoreCase(description);

        return transactionsList.stream().map(t -> {
            Expense expense = new Expense();
            expense.setDescription(t.getDescription());
            expense.setDate(t.getEnterDate().toLocalDateTime().toLocalDate());
            for (Splits splits : t.getSplit()) {
                if (splits.getValueNum() > 0) {
                    expense.setAccountTo(splits.getAccount().getDescription());
                    expense.setAmount(splits.getValueNum() / 100);
                } else {
                    expense.setAccountFrom(splits.getAccount().getDescription());
                }
            }

            return expense;
        }).toList();

    }
}