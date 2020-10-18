package pl.sda.moneymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomesDto extends BasesDto {


    private long incomeValueInCent;
    private PersonDto person;
    private IncomeSourceDto incomeSource;

}
