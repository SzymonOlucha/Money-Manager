package pl.sda.moneymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime creationTimestamp;
    private LocalDateTime updateTimestamp;
    @PrePersist
    void setCreationTimestamp(){
        creationTimestamp=LocalDateTime.now();
        updateTimestamp=LocalDateTime.now();
    }
    @PreUpdate
    void setUpdateTimestamp(){
        updateTimestamp=LocalDateTime.now();
    }
}
