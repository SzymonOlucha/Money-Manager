package pl.sda.moneymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name =  "INCOMES")
public class Income extends BaseEntity {

    private long incomeValueInCent;

    @ManyToOne

    private Person person;


    @ManyToOne
    private IncomeSource incomeSource;
}
