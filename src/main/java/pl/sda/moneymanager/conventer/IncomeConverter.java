package pl.sda.moneymanager.conventer;

import org.mapstruct.Mapper;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.dto.IncomeDto;

@Mapper(componentModel = "spring")
public interface IncomeConverter extends GenericConverter<Income, IncomeDto> {


}
