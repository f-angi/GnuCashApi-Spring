package party.fangi.gnucashapi.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import party.fangi.gnucashapi.model.Expense;
import party.fangi.gnucashapi.model.Sort;
import party.fangi.gnucashapi.model.TransactionType;
import party.fangi.gnucashapi.service.ExpensesService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "${application.cors-origins}", maxAge = 3600)
@RequiredArgsConstructor
public class ExpensesController {

    private final ExpensesService expensesService;

    @Operation(
            summary = "Get a paginated list of expenses",
            parameters = {
                    @Parameter(name = "description", description = "The description of the expense to filter by", schema = @Schema(type = "string"), example = "rent"),
                    @Parameter(name = "accountName", description = "The name of the account to filter by", schema = @Schema(type = "string"), example = "Utilities"),
                    @Parameter(name = "transactionType", description = "The type of transaction to filter by (EXPENSE, INCOME, or ALL)", schema = @Schema(implementation = TransactionType.class, defaultValue = "ALL")),
                    @Parameter(name = "pageNumber", description = "The page number to retrieve", schema = @Schema(type = "integer"), example = "0"),
                    @Parameter(name = "pageSize", description = "The number of items per page", schema = @Schema(type = "integer"), example = "10"),
                    @Parameter(name = "sortBy", description = "The field to sort the results by", schema = @Schema(type = "string"), example = "description"),
                    @Parameter(name = "sortDirection", description = "The direction to sort the results", schema = @Schema(implementation = Direction.class), example = "ASC")
            },
            tags = "api"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful response, returns a page of expenses",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PageExpense.class)
                    )
            )
    })
    @GetMapping(value = "/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
    @SecurityRequirement(name = "bearer")
    public ResponseEntity<Page<Expense>> getExpenses(
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String accountName,
            @RequestParam(required = false, defaultValue = "ALL") TransactionType transactionType,
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) Direction sortDirection) {

        Sort sort = Sort.builder()
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .sortField(sortBy)
                .sortDirection(sortDirection)
                .build();

        return ResponseEntity.ok(expensesService.getExpensesByDescriptionAndAccountNameAndSort(description, accountName, transactionType, sort));
    }

}
