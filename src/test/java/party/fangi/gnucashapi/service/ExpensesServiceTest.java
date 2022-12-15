package party.fangi.gnucashapi.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import party.fangi.gnucashapi.model.Expense;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:db-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ExpensesServiceTest {

    @Autowired
    private ExpensesService expensesService;

    @Test
    void shouldGetTransationcsByDescription() {
        List<Expense> expenseList = expensesService.getExpensesByDescription("Dinner");
        assertEquals(1, expenseList.size());
        Expense expense = expenseList.get(0);
        assertEquals("dinner", expense.getDescription());
        assertEquals(60, expense.getAmount(), 0.0);
        assertEquals("Cash in Wallet", expense.getAccountFrom());
        assertEquals("Recreation", expense.getAccountTo());
        assertEquals(LocalDate.parse("2022-09-01"), expense.getDate());
    }
}