package pl.sda.moneymanager.conventer;

public interface GenericConverter<R,T> {

    T fromEntityToDto(R entity);
    R fromDtoToEntity(T dto);
}