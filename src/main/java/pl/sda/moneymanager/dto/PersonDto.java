package pl.sda.moneymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.moneymanager.domain.Sex;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String name;
    private String surname;
    private String sex;
}
