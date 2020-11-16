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

    public Optional<PersonDto> findPersonById(Long id){
        log.info("find person by id: [{}]",id);
        Optional<Person> result = personRepository.findById(id);
        return result.map(personConverter::fromEntityToDto);
    }

    public void deletePersonById(Long id){
        personRepository.deleteById(id);
        log.info("delete person by id: [{}]", id);
    }

    public Person createPerson(Person toSavePerson){
        log.info("save person");
        return personRepository.save(toSavePerson);
    }

    public Person updatePerson(Person updatePerson){
        return personRepository.save(updatePerson);
    }
    public List<PersonDto> findPersonByName(Person person){

        Example <Person> personExample = Example.of(person);
        List<Person> result = personRepository.findAll(personExample);
        return convertPerson(result);
    }

}
