package party.fangi.gnucashapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import party.fangi.gnucashapi.model.Expense;
import party.fangi.gnucashapi.model.TransactionType;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:insert-db-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:delete-db-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ExpensesServiceTest {

    @Autowired
    private ExpensesService expensesService;

    @Test
    void shouldGetTransactionsByDescription() {
        Page<Expense> expensePage = expensesService.getExpensesByDescriptionAndAccountName("Dinner", "", TransactionType.EXPENSE);
        assertEquals(1, expensePage.getContent().size());
        Expense expense = expensePage.getContent().get(0);
        assertEquals("dinner", expense.getDescription());
        assertEquals(60, expense.getAmount(), 0.0);
        assertEquals("Cash in Wallet", expense.getAccountFrom());
        assertEquals("Recreation", expense.getAccountTo());
        assertEquals(LocalDate.parse("2022-09-01"), expense.getDate());
    }

    @Test
    void shouldGetAllTransactionsWithFilters() {
        Page<Expense> expensePage = expensesService.getExpensesByDescriptionAndAccountName(
            "Dinner", "Recreation", TransactionType.ALL);

        assertEquals(1, expensePage.getContent().size());
        Expense expense = expensePage.getContent().get(0);
        assertEquals("dinner", expense.getDescription());
        assertEquals("Recreation", expense.getAccountTo());
    }
}
