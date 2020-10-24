package pl.sda.moneymanager.converter;

import org.mapstruct.Mapper;
import pl.sda.moneymanager.domain.BaseEntity;
import pl.sda.moneymanager.dto.BaseDto;

@Mapper(componentModel = "spring")
public interface BaseConverter extends GenericConverter<BaseEntity, BaseDto> {
}
