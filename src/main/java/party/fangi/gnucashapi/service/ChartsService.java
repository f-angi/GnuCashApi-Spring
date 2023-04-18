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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
    public ChartData getIncomeExpenseBarChartPerMonth() {
        LocalDateTime from = ZonedDateTime.now().with(TemporalAdjusters.firstDayOfYear()).minus(1, ChronoUnit.YEARS).truncatedTo(ChronoUnit.DAYS)
                .withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
        LocalDateTime to = ZonedDateTime.now().with(TemporalAdjusters.firstDayOfNextMonth()).truncatedTo(ChronoUnit.DAYS)
                .withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();

        List<AmountPerPeriod> incomes = transactionRepository.sumAccountAmountPerMonth(AccountType.INCOME, Timestamp.valueOf(from), Timestamp.valueOf(to));
        List<AmountPerPeriod> expenses = transactionRepository.sumAccountAmountPerMonth(AccountType.EXPENSE, Timestamp.valueOf(from), Timestamp.valueOf(to));

        return getIncomeExpenseBarChart(incomes, expenses, new SimpleDateFormat("yyyy-MM"));
    }

    /**
     * Get bar chart data in chart.js format, split by year for the last 10 years
     *
     * @return
     */
    @Transactional
    public ChartData getIncomeExpenseBarChartPerYear() {
        LocalDateTime to = ZonedDateTime.now().with(TemporalAdjusters.lastDayOfYear()).plusDays(1).truncatedTo(ChronoUnit.DAYS)
                .withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
        LocalDateTime from = ZonedDateTime.now().with(TemporalAdjusters.firstDayOfYear()).minus(10, ChronoUnit.YEARS).truncatedTo(ChronoUnit.DAYS)
                .withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();

        List<AmountPerPeriod> incomes = transactionRepository.sumAccountAmountPerYear(AccountType.INCOME, Timestamp.valueOf(from), Timestamp.valueOf(to));
        List<AmountPerPeriod> expenses = transactionRepository.sumAccountAmountPerYear(AccountType.EXPENSE, Timestamp.valueOf(from), Timestamp.valueOf(to));

        return getIncomeExpenseBarChart(incomes, expenses, new SimpleDateFormat("yyyy"));
    }

    private ChartData getIncomeExpenseBarChart(List<AmountPerPeriod> incomes, List<AmountPerPeriod> expenses, SimpleDateFormat sdf) {
        List<AmountPerPeriod> profitPerMonth = StreamUtils.zip(incomes.stream(), expenses.stream(),
                (x, y) ->
                        new AmountPerPeriod(x.getPeriod(), x.getAmount() + y.getAmount())
        ).toList();

        ChartData chartData = new ChartData();
        chartData.getDatasets().add(new ChartData.DataSet("income", incomes.stream().map(x -> x.getAmount() / 100f).toList()));
        chartData.getDatasets().add(new ChartData.DataSet("expense", expenses.stream().map(x -> x.getAmount() / 100f).toList()));
        chartData.getDatasets().add(new ChartData.DataSet("profit", profitPerMonth.stream().map(x -> x.getAmount() / 100f).toList()));
        chartData.setLabels(incomes.stream().map(x -> sdf.format(x.getPeriod())).toList());

        return chartData;
    }

}