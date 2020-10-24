package pl.sda.moneymanager.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.moneymanager.dto.IncomeDto;
import pl.sda.moneymanager.exception.MoneyGenericException;
import pl.sda.moneymanager.service.IncomeService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest")
public class IncomeRestController {

    private final IncomeService incomeService;

    public IncomeRestController(final IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    // /rest/incomes
    @GetMapping("/incomes")
    // ResponseEntity = status code + payload
    ResponseEntity<List<IncomeDto>> allIncomes() {
        log.info("reading all incomes");

        return new ResponseEntity<>(incomeService.readAllIncomes(), HttpStatus.OK);
    }

    // /rest/incomes/1
    @GetMapping("/incomes/{id}")
    ResponseEntity<IncomeDto> findIncomeById(@PathVariable("id") Long idik) {
        log.info("finding income by id: [{}]", idik);

        ResponseEntity<IncomeDto> result = ResponseEntity
            .notFound()
            .build();
        var searchResult = incomeService.findIncomeById(idik);
        if (searchResult.isPresent()) {
            result = new ResponseEntity<>(searchResult.get(), HttpStatus.OK);
        }

        return result;
    }

    @GetMapping("/v2/incomes/{id}")
    ResponseEntity<IncomeDto> findIncomeByIdV2(@PathVariable("id") Long idik) {
        log.info("finding income by id: [{}]", idik);

        IncomeDto foundResult = incomeService
            .findIncomeById(idik)
            .orElseThrow(MoneyGenericException::new);

        return ResponseEntity.ok(foundResult);
    }
}
