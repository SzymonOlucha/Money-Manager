package pl.sda.moneymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
    void setCreationTimestamp() {
        creationTimestamp = LocalDateTime.now();
        updateTimestamp = creationTimestamp;
    }

    @PreUpdate
    void setUpdateTimestamp() {
        updateTimestamp = LocalDateTime.now();
    }
}
