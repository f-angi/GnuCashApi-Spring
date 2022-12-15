package party.fangi.gnucashapi.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import party.fangi.gnucashapi.model.Expense;
import party.fangi.gnucashapi.service.ExpensesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExpensesController {

    @Value("${app.default.page.size}")
    private int defaultPageSize;

    @Value("${app.default.sort.field}")
    private String defaultSortField;


    private final ExpensesService expensesService;

    @GetMapping(value = "/expenses/{description}", produces = "application/json")
    public ResponseEntity<List<Expense>> getExpenses(@PathVariable String description) {
        return ResponseEntity.ok(expensesService.getExpensesByDescription(description));
    }

    @GetMapping(value = "/expenses-page/{pageNumber}/{pageSize}", produces = "application/json")
    public ResponseEntity<Page<Expense>> getExpensesPaginated(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok(expensesService.getExpensesPaginated(pageNumber, pageSize));
    }

    @GetMapping(value = "/expenses", produces = "application/json")
    public ResponseEntity<List<Expense>> getExpensesListPaginated() {
        return ResponseEntity.ok(expensesService.getExpensesPaginated(0, defaultPageSize).toList());
    }

    @GetMapping(value = "/expenses/{pageNumber}/{pageSize}", produces = "application/json")
    public ResponseEntity<List<Expense>> getExpensesListPaginated(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok(expensesService.getExpensesPaginated(pageNumber, pageSize).toList());
    }
}