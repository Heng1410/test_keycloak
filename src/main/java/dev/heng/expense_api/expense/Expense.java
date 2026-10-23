    package dev.heng.expense_api.expense;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.DecimalMin;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;

    import java.math.BigDecimal;

    @Entity
    @Table(name = "expenses")
    public class Expense {
        @Id
        @GeneratedValue
        private Long id;

        @NotBlank
        @Size(max = 200)
        @Column(nullable = false, length = 200)
        private String title;

        @NotNull
        @DecimalMin(value = "0.01")
        @Column(nullable = false, precision = 12, scale = 2)
        private BigDecimal amount;

        @Size(max = 1000)
        @Column(length = 1000)
        private String description;

        public Expense(){}

        public Long getId(){
            return id;
        }

        public String getTitle(){
            return title;
        }

        public void setTitle(String title){
            this.title = title;
        }
        
        public BigDecimal getAmount(){
            return amount;
        }

        public void setAmount(BigDecimal amount){
            this.amount = amount;
        }

        public String getDescription(){
            return description;
        }

        public void setDescription(String description){
            this.description = description;
        }
    }