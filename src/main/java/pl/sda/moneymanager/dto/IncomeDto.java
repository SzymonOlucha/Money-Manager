package pl.sda.moneymanager.dto;

import lombok.Builder;
import lombok.Value;
import pl.sda.moneymanager.domain.IncomeSource;
import pl.sda.moneymanager.domain.Person;

import java.time.LocalDateTime;

@Value
@Builder
public class IncomeDto  {
    private Long id;
    private LocalDateTime creationTimestamp;
    private LocalDateTime updateTimestamp;
    private long incomeValueCent;
    private Person person;
    private IncomeSource incomeSource;

}
