package pl.sda.moneymanager.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.moneymanager.dto.NBPDto;
import pl.sda.moneymanager.service.NBPService;

import java.util.List;

@RestController
@RequestMapping("/NBP")
public class NBPController {
    private final NBPService nbpService;

    public NBPController(NBPService nbpService) {
        this.nbpService = nbpService;
    }
    @GetMapping("/usd")
    public NBPDto chosenUSD(){
        return nbpService.usd();
    }

    @GetMapping("/chosenCurrency/{x}")
    public NBPDto chosenCurrency(@PathVariable("x") String myCurrency){
        return nbpService.exchangeRateTodayOfGivenCurrency(myCurrency);
    }
    @GetMapping("/ex/{x}")
    public NBPDto chosenCurrencyAndDate(@PathVariable ("x") String myCurrency){
        return nbpService.exchangeRateTodayOfGivenCurrencyAndDate(myCurrency);
    }


}
