package pl.sda.moneymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.moneymanager.domain.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}
