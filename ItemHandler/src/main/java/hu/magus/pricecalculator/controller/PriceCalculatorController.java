package hu.magus.pricecalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceCalculatorController {

    @GetMapping("/test")
    public String test() {
        return "The calculator is working";
    }
}
