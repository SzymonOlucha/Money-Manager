package pl.sda.moneymanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class FirstHtmlController {


    @GetMapping("/first")
    String myFirstPage(){

        return "my-first-page";
    }
}
