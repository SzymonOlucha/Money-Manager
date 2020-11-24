package pl.sda.moneymanager.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class LocalizationOfExpense extends BaseEntity {
    private String nameCompany;
    private String city;
    private String street;
    private String postCode;
}
