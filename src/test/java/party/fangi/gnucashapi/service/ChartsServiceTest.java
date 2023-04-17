package party.fangi.gnucashapi.service;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import party.fangi.gnucashapi.model.AccountType;
import party.fangi.gnucashapi.model.AmountPerPeriod;
import party.fangi.gnucashapi.model.ChartData;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:insert-db-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:delete-db-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ChartsServiceTest {

    @Autowired
    private ChartsService chartsService;

    @Test
    void getIncomeExpensePieChart() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

        ChartData incomeExpensePieChart = chartsService.getIncomeExpenseBarChartByMonth();

        // FIXME
        int x = 2;
    }
}