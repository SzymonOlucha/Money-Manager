package pl.sda.moneymanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.domain.IncomeSource;
import pl.sda.moneymanager.service.IncomeService;

@RestController
public class TestController {

    final private IncomeService incomeService;

    public TestController( final IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/create-test-income")
    Income creationTest(){
        Income income = Income.builder().incomeValueInCent(20000100).build();


        return incomeService.createIncome(income);
    }
}
