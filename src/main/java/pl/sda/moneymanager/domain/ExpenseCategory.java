package pl.sda.moneymanager.domain;

import lombok.*;

import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCategory extends BaseEntity {
    private String nameCategory;
}
