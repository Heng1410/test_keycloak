package dev.heng.expense_api.expense.dto;

import java.math.BigDecimal;

public class ExpenseResponse {
    private Long id;
    private String title;
    private BigDecimal amount;
    private String description;

    public ExpenseResponse(
            Long id,
            String title,
            BigDecimal amount,
            String description
    ){
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.description = description;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public String getDescription(){
        return description;
    }
}
