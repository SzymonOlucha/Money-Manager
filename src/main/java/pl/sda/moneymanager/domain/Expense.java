package pl.sda.moneymanager.domain;

;
import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends BaseEntity {
    private long  valueOfExpense;

    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @ManyToOne (cascade = CascadeType.ALL)
    private  ExpenseCategory expenseCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person owner;

    @ManyToOne (cascade = CascadeType.ALL)
    private LocalizationOfExpense localization;

    private String note;


}
