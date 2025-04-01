package party.fangi.gnucashapi.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "api")
public class ChartsController {

    private final ChartsService chartsService;

    @Operation(summary = "Get income/expense bar chart data per month", tags = "api")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Successful response, returns a chart data object",
            content = @io.swagger.v3.oas.annotations.media.Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ChartData.class)
            )
        )
    })
    @GetMapping(value = "/bar/month", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChartData> getIncomeExpenseBarChartPerMonth() {
        ChartData incomeExpensePieChart = chartsService.getIncomeExpenseBarChartPerMonth();
        return ResponseEntity.ok(incomeExpensePieChart);
    }

    @Operation(summary = "Get income/expense bar chart data per year", tags = "api")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Successful response, returns a chart data object",
            content = @io.swagger.v3.oas.annotations.media.Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ChartData.class)
            )
        )
    })
    @GetMapping(value = "/bar/year", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChartData> getIncomeExpenseBarChartPerYear() {
        ChartData incomeExpensePieChart = chartsService.getIncomeExpenseBarChartPerYear();
        return ResponseEntity.ok(incomeExpensePieChart);
    }

}
