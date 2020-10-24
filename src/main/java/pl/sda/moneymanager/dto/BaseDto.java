package pl.sda.moneymanager.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDto {
    protected Long id;
    protected LocalDateTime creationTimestamp;
    protected LocalDateTime updateTimestamp;
}
