package party.fangi.gnucashapi.persistence.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import party.fangi.gnucashapi.persistence.model.Splits;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:db-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class SplitRepositoryTest {

    @Autowired
    private SplitRepository splitRepository;

    @Test
    public void shouldFindSplitByGuid() {
        List<Splits> splitsList = splitRepository.findByGuid("ef8cae4d18be4a1b86436274ec5d7c02");
        assertEquals(1, splitsList.size());
        assertEquals("da4dbc25f09d40abb447ee1f42db568f", splitsList.get(0).getTransaction().getGuid());
    }

    @Test
    public void shouldFindSplitByTransactionAndAccount() {
        List<Splits> splitsList = splitRepository.findByTransactionDescriptionContainsIgnoreCaseAndAccountNameIgnoreCase("dinNeR", "recreatIoN");
        assertEquals(1, splitsList.size());
        assertEquals("e0def90a05454325b00378109a0e32e9", splitsList.get(0).getGuid());
        assertEquals("32a565f24a3d4d2da4027f4d5d4d829b", splitsList.get(0).getTransaction().getGuid());
    }
}