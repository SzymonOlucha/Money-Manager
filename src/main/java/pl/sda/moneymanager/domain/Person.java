package pl.sda.moneymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person extends BaseEntity {
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING) // odpowiada na zamieniem zapisu w bazie dadnych na stringi (domylśnie jest ordinal czyli int)
    private Sex sex;


}
//insert into Person ( sex, surname, name)
//values('MALE','P','A');