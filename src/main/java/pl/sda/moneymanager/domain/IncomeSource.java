package pl.sda.moneymanager.domain;

import lombok.*;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(callSuper = true)
public class IncomeSource extends BaseEntity {
    private String sourceName;
}
