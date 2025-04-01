package party.fangi.gnucashapi.persistence.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import party.fangi.gnucashapi.model.AccountType;
import party.fangi.gnucashapi.model.AmountPerPeriod;
import party.fangi.gnucashapi.persistence.model.Transactions;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:insert-db-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:delete-db-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void shouldFindByDescription() {
        Page<Transactions> transactionsPage = transactionRepository.findByDescriptionContainingIgnoreCase("dInNeR", null);
        assertEquals(1, transactionsPage.getContent().size());
        assertEquals("32a565f24a3d4d2da4027f4d5d4d829b", transactionsPage.getContent().get(0).getGuid());
    }

    @Test
    void shouldFindByAccountName() {
        Page<Transactions> transactionsPage = transactionRepository.findBySplitAccountNameContainingIgnoreCase("recreation", null);
        assertEquals(3, transactionsPage.getContent().size());
    }

    @Test
    void shouldFindByDescriptionAndAccountName() {
        Page<Transactions> transactionsPage = transactionRepository.findByDescriptionContainingIgnoreCaseAndSplitAccountNameContainingIgnoreCase("inner", "recreatio", null);
        assertEquals(1, transactionsPage.getContent().size());
    }

    @Test
    void shouldFindExpenseTransactions() {
        Page<Transactions> expenseTransactions = transactionRepository.findExpenseTransactions("dinner", "recreation", null);
        assertEquals(1, expenseTransactions.getContent().size());
        assertEquals("32a565f24a3d4d2da4027f4d5d4d829b", expenseTransactions.getContent().get(0).getGuid());
    }

    @Test
    void shouldFindIncomeTransactions() {
        Page<Transactions> incomeTransactions = transactionRepository.findIncomeTransactions("salary", "salary", null);
        assertEquals(1, incomeTransactions.getContent().size());
        assertEquals("da4dbc25f09d40abb447ee1f42db568f", incomeTransactions.getContent().get(0).getGuid());
    }

    @Test
    void shouldFindAllTransactionsWithFilters() {
        Page<Transactions> allTransactions = transactionRepository.findTransactions("dinner", "recreation", null);
        assertEquals(1, allTransactions.getContent().size());
        assertEquals("32a565f24a3d4d2da4027f4d5d4d829b", allTransactions.getContent().get(0).getGuid());
    }

    @Test
    void shouldSumAccountAmountPerYear() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<AmountPerPeriod> amountPerPeriods = transactionRepository.sumAccountAmountPerYear(AccountType.EXPENSE,
                new Timestamp(simpleDateFormat.parse("2020-01-01").getTime()),
                new Timestamp(simpleDateFormat.parse("2024-01-01").getTime()));

        assertEquals(2, amountPerPeriods.size());
    }

    @Test
    void shouldSumAccountAmountPerMonth() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<AmountPerPeriod> amountPerPeriods = transactionRepository.sumAccountAmountPerMonth(AccountType.EXPENSE,
                new Timestamp(simpleDateFormat.parse("2020-01-01").getTime()),
                new Timestamp(simpleDateFormat.parse("2024-01-01").getTime()));

        assertEquals(2, amountPerPeriods.size());
    }

    @Test
    void shouldFindAllTransactionsWithPagination() {
        Page<Transactions> allTransactions = transactionRepository.findAll(PageRequest.of(0, Integer.MAX_VALUE));
        assertEquals(5, allTransactions.getContent().size());
    }

}
