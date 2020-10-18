package pl.sda.moneymanager.converter;

import org.mapstruct.Mapper;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.dto.IncomesDto;

@Mapper(componentModel = "spring")
public interface IncomesConverter extends GenericConverter<Income, IncomesDto> {


}
