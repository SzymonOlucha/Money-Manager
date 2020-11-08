package pl.sda.moneymanager.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
public class Person extends BaseEntity {
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Sex sex;
}
