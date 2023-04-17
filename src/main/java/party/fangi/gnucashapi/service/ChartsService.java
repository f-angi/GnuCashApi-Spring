package party.fangi.gnucashapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import party.fangi.gnucashapi.model.AccountType;
import party.fangi.gnucashapi.model.AmountPerPeriod;
import party.fangi.gnucashapi.model.ChartData;
import party.fangi.gnucashapi.persistence.repository.TransactionRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChartsService {

    private final TransactionRepository transactionRepository;

    /**
     * Get bar chart data in chart.js format, split by month for the last year
     *
     * @return
     */
    @Transactional
    public ChartData getIncomeExpenseBarChartByMonth() {
        LocalDateTime to = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime from = to.minus(1, ChronoUnit.YEARS);

        List<AmountPerPeriod> incomePerMonth = transactionRepository.sumAccountAmountPerMonth(AccountType.INCOME, Timestamp.valueOf(from), Timestamp.valueOf(to));
        List<AmountPerPeriod> expensePerMonth = transactionRepository.sumAccountAmountPerMonth(AccountType.EXPENSE, Timestamp.valueOf(from), Timestamp.valueOf(to));

        return getIncomeExpenseBarChart(incomePerMonth, expensePerMonth);
    }

    /**
     * Get bar chart data in chart.js format, split by year for the last 10 years
     *
     * @return
     */
    @Transactional
    public ChartData getIncomeExpenseBarChartByYear() {
        LocalDateTime to = LocalDateTime.now().with(TemporalAdjusters.lastDayOfYear());
        LocalDateTime from = to.minus(10, ChronoUnit.YEARS);

        List<AmountPerPeriod> incomePerMonth = transactionRepository.sumAccountAmountPerYear(AccountType.INCOME, Timestamp.valueOf(from), Timestamp.valueOf(to));
        List<AmountPerPeriod> expensePerMonth = transactionRepository.sumAccountAmountPerYear(AccountType.EXPENSE, Timestamp.valueOf(from), Timestamp.valueOf(to));

        return getIncomeExpenseBarChart(incomePerMonth, expensePerMonth);
    }

    private ChartData getIncomeExpenseBarChart(List<AmountPerPeriod> incomePerMonth, List<AmountPerPeriod> expensePerMonth) {
        List<AmountPerPeriod> profitPerMonth = StreamUtils.zip(incomePerMonth.stream(), expensePerMonth.stream(),
                (x, y) ->
                        new AmountPerPeriod(x.getPeriod(), x.getAmount() + y.getAmount())
        ).toList();

        ChartData chartData = new ChartData();
        chartData.getDatasets().add(new ChartData.DataSet("income", incomePerMonth.stream().map(x -> x.getAmount() / 100f).toList()));
        chartData.getDatasets().add(new ChartData.DataSet("expense", expensePerMonth.stream().map(x -> x.getAmount() / 100f).toList()));
        chartData.getDatasets().add(new ChartData.DataSet("profit", profitPerMonth.stream().map(x -> x.getAmount() / 100f).toList()));
        chartData.setLabels(incomePerMonth.stream().map(x -> x.getPeriod().toString()).toList());

        return chartData;
    }

}