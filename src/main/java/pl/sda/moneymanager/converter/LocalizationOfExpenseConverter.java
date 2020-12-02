package pl.sda.moneymanager.converter;


import org.mapstruct.Mapper;
import pl.sda.moneymanager.domain.LocalizationOfExpense;
import pl.sda.moneymanager.dto.LocalizationOfExpenseDto;
@Mapper(componentModel = "spring")
public interface LocalizationOfExpenseConverter extends GenericConverter<LocalizationOfExpense, LocalizationOfExpenseDto> {
}
