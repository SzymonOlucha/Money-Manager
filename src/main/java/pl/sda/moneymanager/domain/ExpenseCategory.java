package pl.sda.moneymanager.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ExpenseCategory extends BaseEntity {
    private String nameCategory;
}
