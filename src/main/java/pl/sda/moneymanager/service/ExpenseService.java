package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.moneymanager.converter.ExpenseConverter;
import pl.sda.moneymanager.repository.ExpenseRepository;

@Service
@Slf4j
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseConverter expenseConverter;

    public ExpenseService( final ExpenseRepository expenseRepository, final ExpenseConverter expenseConverter) {
        this.expenseRepository = expenseRepository;
        this.expenseConverter = expenseConverter;
    }

}
