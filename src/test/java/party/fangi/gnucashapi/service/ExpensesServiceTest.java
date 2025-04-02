package party.fangi.gnucashapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import party.fangi.gnucashapi.model.Expense;
import party.fangi.gnucashapi.model.TransactionType;
import party.fangi.gnucashapi.persistence.model.Splits;
import party.fangi.gnucashapi.persistence.model.Transactions;
import party.fangi.gnucashapi.persistence.repository.SplitRepository;
import party.fangi.gnucashapi.persistence.repository.TransactionRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:insert-db-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:delete-db-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ExpensesServiceTest {

    @Autowired
    private ExpensesService expensesService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SplitRepository splitRepository;

    @Value("${application.currency-guid}")
    private String currencyGuid;


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

    @Test
    void shouldCreateTransaction() {
        final LocalDate transactionDate = java.time.LocalDate.of(2023, 5, 1);
        final String description = "the hitchhiker's guide to the galaxy";
        final String accountFrom = "checking account";
        final String accountTo = "books";
        final float amount = 42;

        Transactions createdTransaction = expensesService.createTransaction(transactionDate, description, accountFrom, accountTo, amount);

        final Page<Transactions> page = transactionRepository.findByDescriptionContainingIgnoreCase(description, PageRequest.of(0, 10));
        assertEquals(1, page.getContent().size());

        final Transactions transaction = page.getContent().get(0);
        assertEquals(description, transaction.getDescription());
        assertEquals(Timestamp.valueOf(transactionDate.atStartOfDay()), transaction.getPostDate());
        assertNotNull(transaction.getEnterDate());
        assertEquals(createdTransaction.getEnterDate().getTime(), transaction.getEnterDate().getTime());
        assertNotNull(createdTransaction.getGuid());
        assertEquals(currencyGuid, createdTransaction.getCurrencyGuid());

        final List<Splits> splits = transaction.getSplit().stream().sorted(Comparator.comparing(Splits::getValueNum)).collect(Collectors.toList());
        assertEquals(2, splits.size());

        final var splitFrom = splits.get(0);
        assertEquals(accountFrom.toLowerCase(), splitFrom.getAccount().getName().toLowerCase());
        assertEquals(-amount * 100, splitFrom.getValueNum());

        final var splitTo = splits.get(1);
        assertEquals(accountTo.toLowerCase(), splitTo.getAccount().getName().toLowerCase());
        assertEquals(amount * 100, splitTo.getValueNum());
    }

    @Test
    void shouldFailCreateTransactionIfAccountFromNotFound() {
        final LocalDate transactionDate = java.time.LocalDate.of(2023, 5, 1);
        final String description = "the hitchhiker's guide to the galaxy";
        final String accountFrom = "not existing account";
        final String accountTo = "books";
        final float amount = 42;

        assertThrows(NoSuchElementException.class,
                () -> expensesService.createTransaction(transactionDate, description, accountFrom, accountTo, amount));
    }

    @Test
    void shouldFailCreateTransactionIfAccountToNotFound() {
        final LocalDate transactionDate = java.time.LocalDate.of(2023, 5, 1);
        final String description = "the hitchhiker's guide to the galaxy";
        final String accountFrom = "checking account";
        final String accountTo = "not existing account";
        final float amount = 42;

        assertThrows(NoSuchElementException.class,
                () -> expensesService.createTransaction(transactionDate, description, accountFrom, accountTo, amount));
    }
}
