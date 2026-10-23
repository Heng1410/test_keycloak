package dev.heng.expense_api.expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository
extends JpaRepository<Expense, Long> {
}