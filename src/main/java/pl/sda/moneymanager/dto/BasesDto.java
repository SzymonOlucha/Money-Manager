package pl.sda.moneymanager.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BasesDto {
    protected Long id;
    protected LocalDateTime creationTimestamp;
    protected LocalDateTime updateTimestamp;
}
