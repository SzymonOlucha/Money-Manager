package pl.sda.moneymanager.domain;

;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;


@Data
@Entity
public class Expense extends BaseEntity {
    private float valueOfTheExpense;

    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @ManyToOne
    private  ExpenseCategory expenseCategory;

    @ManyToOne
    private Person owner;

    @ManyToOne
    private LocalizationOfExpense localizationOfExpense;

    private String note;


}
