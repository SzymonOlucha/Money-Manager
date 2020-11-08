package pl.sda.moneymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.moneymanager.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByName(String name);
    boolean existsByNameAndSurname(String name, String surname);
}
