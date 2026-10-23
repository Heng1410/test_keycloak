package dev.heng.expense_api.expense.mapper;

import dev.heng.expense_api.expense.Expense;
import dev.heng.expense_api.expense.dto.ExpenseRequest;
import dev.heng.expense_api.expense.dto.ExpenseResponse;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {
    public Expense toEntity(ExpenseRequest request){
        Expense expense = new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());
        return expense;
    }
    public ExpenseResponse toResponse(Expense expense) {
        return new ExpenseResponse(
                expense.getId(),
                expense.getTitle(),
                expense.getAmount(),
                expense.getDescription()
        );
    }
}
