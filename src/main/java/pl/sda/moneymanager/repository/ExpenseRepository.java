package pl.sda.moneymanager.repository;

import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.moneymanager.domain.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
