package pl.sda.moneymanager.converter;

import org.mapstruct.Mapper;
import pl.sda.moneymanager.domain.Person;
import pl.sda.moneymanager.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonConverter extends GenericConverter<Person, PersonDto> {
}
