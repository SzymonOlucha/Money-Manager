package pl.sda.moneymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;


@Data
public class RatesDto {

    @JsonProperty("effectiveDate")
    private LocalDate dateOfRecording;

    @JsonProperty("ask")
    private double currencySellingPrice;
}
