package party.fangi.gnucashapi.persistence.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import party.fangi.gnucashapi.persistence.model.Transactions;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:db-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void shouldFindByDescription() {
        List<Transactions> transactionsList = transactionRepository.findByDescriptionContainingIgnoreCase("dInNeR");
        assertEquals(1, transactionsList.size());
        assertEquals("32a565f24a3d4d2da4027f4d5d4d829b", transactionsList.get(0).getGuid());
    }

}