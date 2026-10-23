package dev.heng.expense_api.expense;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    public Page<Expense> getAllExpense(Pageable pageable){
        return expenseRepository.findAll(pageable);
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found with id: " + id));
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense existingExpense = getExpenseById(id);

        existingExpense.setTitle(updatedExpense.getTitle());
        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setDescription(updatedExpense.getDescription());

        return expenseRepository.save(existingExpense);
    }

    public void deleteExpense(Long id) {
        Expense expense = getExpenseById(id);
        expenseRepository.delete(expense);
    }
        }