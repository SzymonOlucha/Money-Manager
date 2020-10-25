package pl.sda.moneymanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@RequestMapping("/demo")
public class FirstHtmlController {


    private static final String SURNAME_KEY = "surnameKey";
    private static final String NAME_KEY = "nameKey";

    @GetMapping("/first")
    String myFirstPage(){

        return "my-first-page";
    }

    @GetMapping("/my-name")
    String displayMyData(@RequestParam(value = "name", defaultValue = "anonim") String myName,
                         @RequestParam(value = "surname", required = false) String mySurname,
                         Model model){
        log.info("display my data with params, name =  [{}], surname = [{}]", myName, mySurname);
         model.addAttribute(NAME_KEY,myName)
         .addAttribute(SURNAME_KEY, mySurname);

        return"trial/my-data";
    }
}
