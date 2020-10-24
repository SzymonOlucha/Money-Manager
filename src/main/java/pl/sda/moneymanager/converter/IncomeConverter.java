package pl.sda.moneymanager.converter;

import org.mapstruct.Mapper;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.dto.IncomeDto;

@Mapper(componentModel = "spring")
public interface IncomeConverter extends GenericConverter<Income, IncomeDto> {
}
