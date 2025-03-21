package party.fangi.gnucashapi.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping(value = "/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Expense>> getExpenses(
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String accountName,
            @RequestParam(required = false, defaultValue = "ALL") TransactionType transactionType,
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDirection) {

        Sort sort = Sort.builder()
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .sortField(sortBy)
                .sortDirection(sortDirection)
                .build();

        return ResponseEntity.ok(expensesService.getExpensesByDescriptionAndAccountNameAndSort(description, accountName, transactionType, sort));
    }

}
