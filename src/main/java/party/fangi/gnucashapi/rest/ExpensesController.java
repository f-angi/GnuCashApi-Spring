package party.fangi.gnucashapi.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import party.fangi.gnucashapi.model.Expense;
import party.fangi.gnucashapi.model.Sort;
import party.fangi.gnucashapi.service.ExpensesService;

@RestController
@CrossOrigin(origins = "http://192.168.1.5:4200", maxAge = 3600)
@RequiredArgsConstructor
public class ExpensesController {

    private final ExpensesService expensesService;

    @GetMapping(value = "/expenses", produces = "application/json")
    public ResponseEntity<Page<Expense>> getExpenses(
            @RequestParam(required = false) String description,
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

        return ResponseEntity.ok(expensesService.getExpensesByDescription(description, sort));
    }

}