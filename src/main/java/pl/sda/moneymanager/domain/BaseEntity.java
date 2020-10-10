package pl.sda.moneymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    private long id;
    private LocalDateTime creationTimestamp;
    private LocalDateTime updateTimestamp;
}
