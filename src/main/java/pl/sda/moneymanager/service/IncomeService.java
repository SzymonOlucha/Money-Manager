package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.sda.moneymanager.converter.IncomesConverter;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.dto.IncomesDto;
import pl.sda.moneymanager.repository.IncomeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class IncomeService {

    private final IncomeRepository incomeRepository;
    private final IncomesConverter incomesConverter;

    public IncomeService(IncomeRepository incomeRepository, IncomesConverter incomesConverter) {
        this.incomeRepository = incomeRepository;
        this.incomesConverter = incomesConverter;
    }

    public List<Income> readIncomesWithQueryParams(int pageNumber, int pageSize) {
        log.info("reading incomes with query params, page number = [{}], page size = [{}]", pageNumber,
            pageSize);

        var result = incomeRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();

        log.info("result from db: {}", result);
        return result;
    }

    public List<IncomesDto> readAllIncomes() {
        log.info("reading all incomes");
        var dataFromRepo = new ArrayList<Income>();
        //var result = incomeRepository.findAll();
        incomeRepository
                .findAll()
                .forEach(dataFromRepo::add);

        var result =dataFromRepo.stream()
               .map(incomesConverter::fromEntityToDto)
               .collect(Collectors.toList());
        log.info("number of read elements: [{}]", result.size());
        log.debug("result : {}", result);
        return result;
    }

    public Optional<Income> findIncomeById(Long id) {
        log.info("find income by id: [{}]", id);

        var result = incomeRepository.findById(id);
        log.info("result: [{}]", result);
        return result;
    }

    public boolean deleteIncomeById(Long id) {
        log.info("deleting by id: [{}]", id);
        incomeRepository.deleteById(id);
        return true;
    }

    public Income createIncome(Income toSave) {
        var saved = incomeRepository.save(toSave);

        log.info("saved object: [{}]", saved);
        return saved;
    }

    public Income updateIncome(Income toUpdate) {
        var updated = incomeRepository.save(toUpdate);

        log.info("updated object: [{}]", updated);
        return updated;
    }
}
