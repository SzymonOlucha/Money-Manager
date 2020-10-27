package pl.sda.moneymanager.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pl.sda.moneymanager.converter.PersonConverter;
import pl.sda.moneymanager.domain.Person;
import pl.sda.moneymanager.domain.Sex;
import pl.sda.moneymanager.dto.PersonDto;
import pl.sda.moneymanager.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonConverter personConverter;


    public PersonService(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }


    private List<PersonDto> convertPerson(List<Person> result){
        return result.stream()
                .map(personConverter::fromEntityToDto)
                .collect(Collectors.toList());
    }


    public List<PersonDto> readAllPerson(){
        log.info("reading all person");

        List<Person> result = personRepository.findAll();
        return convertPerson(result);
    }


    public List<PersonDto> findPersonByName(String name, String surname, Sex sex){

        Example <Person> personExample = Example.of(new Person(name, surname, sex));
        List<Person> result = personRepository.findAll(personExample);
        return convertPerson(result);
    }

}
