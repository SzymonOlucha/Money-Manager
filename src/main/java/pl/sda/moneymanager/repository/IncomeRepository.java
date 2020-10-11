package pl.sda.moneymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.moneymanager.domain.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
