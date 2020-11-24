package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.moneymanager.dto.NBPDto;

import java.time.LocalDate;
import java.util.Map;

@Service
@Slf4j
public class NBPService {
    private static final String MONEY = "currency";
   // private static final String DATE = "2010-02-12";
    private static final String exchangeRateToday = String.format("http://api.nbp.pl/api/exchangerates/rates/c/{%s}/today/?format=json", MONEY);
    private static final String exchangeRateSelectDay = String.format("http://api.nbp.pl/api/exchangerates/rates/c/{%s}/2020-11-19/?format=json", MONEY);

    private final RestTemplate restTemplate;
    private final String API_KEY;



    public NBPService(final RestTemplate restTemplate, @Value("${security.key:#null}") String apiKey) {
        this.restTemplate = restTemplate;
        API_KEY = apiKey;
    }

    public NBPDto usd() {
        return exchangeRateTodayOfGivenCurrency("usd");
    }

    public NBPDto exchangeRateTodayOfGivenCurrency(String myCurrency){
       log.info("my currency[{}]", myCurrency);
        Map<String,? > params = Map.of(MONEY,myCurrency);
        log.info("[{}]", params);
        var requestResult = restTemplate.getForObject(exchangeRateToday, NBPDto.class, params);
        log.info(" nn [{}]", requestResult);
        return requestResult;
    }

    public  NBPDto exchangeRateTodayOfGivenCurrencyAndDate(String myCurrency){
        Map<String,? > params = Map.of(MONEY,myCurrency);
        log.info("[{}]", params);
        var requestResult = restTemplate.getForObject(exchangeRateSelectDay, NBPDto.class, params);
        log.info(" nn [{}]", requestResult);
        return requestResult;
    }
}
