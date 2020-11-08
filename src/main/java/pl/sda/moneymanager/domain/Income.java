package pl.sda.moneymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Income extends BaseEntity {
    private long incomeValueInCent;

    // FIXME   - very ugly:)
    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    private IncomeSource incomeSource;
}
