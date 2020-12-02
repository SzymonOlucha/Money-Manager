package pl.sda.moneymanager.dto;

import lombok.Data;
import pl.sda.moneymanager.domain.LocalizationOfExpense;
import pl.sda.moneymanager.domain.Person;

@Data
public class ExpenseDto extends BaseDto {
    private long valueOfExpense;
     private String currency;
     private ExpenseCategoryDto expenseCategoryDto;
     private PersonDto owner;
     private LocalizationOfExpenseDto localization;
     private String note;
}
