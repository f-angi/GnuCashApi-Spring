package party.fangi.gnucashapi.rest;

import lombok.RequiredArgsConstructor;
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

    private final ExpensesService expensesService;

    @GetMapping("/expenses/{description}")
    public ResponseEntity<List<Expense>> getExpenses(@PathVariable String description) {
        return ResponseEntity.ok(expensesService.getTransactionsByDescription(description));
    }
}