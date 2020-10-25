package pl.sda.moneymanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demo")
@Slf4j
public class FirstHtmlController {

    private static final String NAME_KEY = "nameKey";
    private static final String SURNAME_KEY = "surnameKey";

    @GetMapping("/first")
    String myFirstPage() {
        return "my-first-page";
    }

    // /demo/my-name?name=mariusz&surname=p.
    @GetMapping("/my-name")
    String displayMyData(@RequestParam(value = "name", defaultValue = "maniek") String myName,
                         @RequestParam(value = "surname", required = false) String mySurname,
                         Model model) {
        log.info("display my data, with params, name = [{}], surname = [{}]", myName, mySurname);

        model.addAttribute(NAME_KEY, myName)
            .addAttribute(SURNAME_KEY, mySurname);
        return "trial/my-data";
    }
}
