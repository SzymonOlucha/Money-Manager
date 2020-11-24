package pl.sda.moneymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

@Data
public class NBPDto {

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("code")
    private String code;
    
    private RatesDto[] rates;
}
