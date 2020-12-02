package pl.sda.moneymanager.dto;

import lombok.Data;

@Data
public class LocalizationOfExpenseDto extends BaseDto {
    private String localizationOfExpense;
    private String city;
    private String street;
    private String postCode;

}
