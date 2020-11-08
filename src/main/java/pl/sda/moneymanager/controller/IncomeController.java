package pl.sda.moneymanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.dto.IncomeDto;
import pl.sda.moneymanager.dto.IncomeSourceDto;
import pl.sda.moneymanager.service.IncomeService;

import java.util.Optional;

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
    public String allIncomes(Model model) {
        log.info("all incomes");
        model.addAttribute(ALL_INCOMES, incomeService.readAllIncomes());

        return "incomes/all-incomes";
    }


    @GetMapping("/delete/{id}")
    public String deleteIncomeById(@PathVariable("id") Long incomeID){
        log.info("deleting income by id :[{}]", incomeID);
        incomeService.deleteIncomeById(incomeID);
        return "redirect:/incomes";
    }

    @GetMapping("/add-form")
    public String showForm(){
        log.info("showing form");

        return "/incomes/add-form";
    }

    @PostMapping("/save")
    public String save(IncomeDto incomeToSave){
        log.info("saving income");
        log.info("name=[{}]", incomeToSave);
        incomeService.saveIncome(incomeToSave);
        return "redirect:/incomes";
    }

    @GetMapping("/edit/{id}")
    public String edit( @PathVariable ("id") Long id, Model model){
        Optional<IncomeDto> incomeDto = incomeService.findIncomeById(id);
        model.addAttribute("income", incomeDto.orElseThrow());
        return "incomes/add-form";
    }

    
}
