package pl.sda.moneymanager.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class LocalizationOfExpense extends BaseEntity {
    private String street;
    private String nameCompany;
    private String postCode;
}
