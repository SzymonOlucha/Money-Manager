package pl.sda.moneymanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.moneymanager.dto.IncomeDto;
import pl.sda.moneymanager.service.IncomeService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/incomes")
public class IncomeController {
    private static final String ALL_INCOMES = "allIncomes";
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }
    @GetMapping
    public String allIncomes(Model model){
        log.info("all incomes");
        model.addAttribute(ALL_INCOMES,incomeService.readAllIncomes());
        return "incomes/all_incomes";
    }
}
