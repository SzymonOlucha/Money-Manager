package pl.sda.moneymanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.moneymanager.dto.IncomeDto;
import pl.sda.moneymanager.service.IncomeService;

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

    // /delete/1
    // /delete/2
    // /delete/id
    @GetMapping("/delete/{id}")
    public String deleteIncomeById(@PathVariable("id") Long incomeId) {
        log.info("deleting income by id: [{}]", incomeId);
        incomeService.deleteIncomeById(incomeId);
        return "redirect:/incomes";
    }

    @GetMapping("/add-form")
    public String showForm() {
        log.info("showing form");
        return "incomes/add-form";
    }

    @PostMapping("/save")
    public String save(IncomeDto incomeToSave) {
        log.info("saving income = [{}]", incomeToSave);
        incomeService.saveIncome(incomeToSave);
        return "redirect:/incomes";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        var incomeDto = incomeService.findIncomeById(id);
        model.addAttribute("income", incomeDto.orElseThrow());
        return "incomes/add-form";
    }
}
