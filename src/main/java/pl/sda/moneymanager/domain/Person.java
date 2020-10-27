package pl.sda.moneymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person extends BaseEntity implements Example {
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Override
    public Object getProbe() {
        return null;
    }

    @Override
    public ExampleMatcher getMatcher() {
        return null;
    }
}
