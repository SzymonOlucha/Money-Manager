package pl.sda.moneymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Income {
    private long id;
    private long incomeValueInPolishCent;
    private LocalDateTime creationTimestamp;
    private LocalDateTime updateTimestamp;
    private Person person;
    private IncomeSource incomeSource;

}
