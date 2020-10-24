package pl.sda.moneymanager.converter;

import org.mapstruct.Mapper;
import pl.sda.moneymanager.domain.IncomeSource;
import pl.sda.moneymanager.dto.IncomeSourceDto;

@Mapper(componentModel = "spring")
public interface IncomeSourceConverter extends GenericConverter<IncomeSource, IncomeSourceDto> {
}
