package party.fangi.gnucashapi.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import party.fangi.gnucashapi.model.ChartData;
import party.fangi.gnucashapi.service.ChartsService;

@RestController
@RequestMapping("api/charts")
@CrossOrigin(origins = "${application.cors-origins}", maxAge = 3600)
@RequiredArgsConstructor
public class ChartsController {

    private final ChartsService chartsService;

    @GetMapping(value = "/bar/month", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChartData> getIncomeExpenseBarChartPerMonth() {
        ChartData incomeExpensePieChart = chartsService.getIncomeExpenseBarChartPerMonth();
        return ResponseEntity.ok(incomeExpensePieChart);
    }

    @GetMapping(value = "/bar/year", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChartData> getIncomeExpenseBarChartPerYear() {
        ChartData incomeExpensePieChart = chartsService.getIncomeExpenseBarChartPerYear();
        return ResponseEntity.ok(incomeExpensePieChart);
    }

}
