package pl.sda.moneymanager.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class LocalizationOfExpense  extends  BaseEntity{

    private String localizationOfExpense;
    private String city;
    private String street;
    private String postCode;


}
