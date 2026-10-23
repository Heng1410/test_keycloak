
package dev.heng.expense_api.expense;


import dev.heng.expense_api.expense.dto.ExpenseRequest;
import dev.heng.expense_api.expense.dto.ExpenseResponse;
import dev.heng.expense_api.expense.mapper.ExpenseMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final ExpenseMapper expenseMapper;

    public ExpenseController(ExpenseService expenseService,ExpenseMapper expenseMapper){
        this.expenseService = expenseService;
        this.expenseMapper = expenseMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExpenseResponse> createExpense(@Valid @RequestBody ExpenseRequest request) {

        Expense expense = expenseMapper.toEntity(request);
        Expense savedExpense = expenseService.createExpense(expense);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(expenseMapper.toResponse(savedExpense));
    }

    @GetMapping
    public Page<ExpenseResponse> getAllExpense(
            @PageableDefault(
                    size=10,
                    sort = "id",
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ){
        return expenseService.getAllExpense(pageable)
                .map(expenseMapper::toResponse);
    }

    @GetMapping("/{id}")
    public ExpenseResponse getExpenseById(@PathVariable Long id){
        Expense expense = expenseService.getExpenseById(id);
        return expenseMapper.toResponse(expense);
    }
    @PutMapping("/{id}")
    public ExpenseResponse updateExpense(
            @PathVariable Long id,
            @Valid @RequestBody ExpenseRequest request
    ){
        Expense expense = expenseMapper.toEntity(request);
        Expense updatedExpense = expenseService.updateExpense(id, expense);
        return expenseMapper.toResponse(updatedExpense);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}