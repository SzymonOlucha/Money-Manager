package pl.sda.moneymanager.converter;

import org.mapstruct.Mapper;
import pl.sda.moneymanager.domain.Expense;
import pl.sda.moneymanager.dto.ExpenseDto;

@Mapper(componentModel = "spring")
public interface ExpenseConverter extends GenericConverter<Expense, ExpenseDto> {
}
