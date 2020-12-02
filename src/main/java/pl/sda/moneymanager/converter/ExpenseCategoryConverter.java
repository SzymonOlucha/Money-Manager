package pl.sda.moneymanager.converter;

import org.mapstruct.Mapper;
import pl.sda.moneymanager.domain.ExpenseCategory;
import pl.sda.moneymanager.dto.BaseDto;
import pl.sda.moneymanager.dto.ExpenseCategoryDto;
@Mapper(componentModel = "spring")
public interface ExpenseCategoryConverter extends GenericConverter<ExpenseCategory, ExpenseCategoryDto> {
}
