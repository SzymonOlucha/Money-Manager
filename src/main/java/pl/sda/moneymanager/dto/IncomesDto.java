package pl.sda.moneymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomesDto extends BasesDto {


    private long incomeValueInCent;
    @JsonProperty("osoba")
    private PersonDto person;
    private IncomeSourceDto incomeSource;

}
