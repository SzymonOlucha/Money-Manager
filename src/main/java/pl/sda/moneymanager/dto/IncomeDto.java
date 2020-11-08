package pl.sda.moneymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDto extends BaseDto {
    private long incomeValueInCent;

    @JsonProperty("osoba")
    private PersonDto person;
    private IncomeSourceDto incomeSource;
}
