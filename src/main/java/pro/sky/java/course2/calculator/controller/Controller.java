package pro.sky.java.course2.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.calculatorservice.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class Controller {
    private final CalculatorService calculatorService;

    public Controller(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String helloCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String sum(@RequestParam(name = "num1", required = false) Integer a,
                      @RequestParam(name = "num2", required = false) Integer b) {
        if (a == 0 || b == 0) {
            return "Какой то из параметров не передан!";
        }
        return buildResultString(a, b, "+", calculatorService.sum(a, b));
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2", required = false) Integer b) {
        if (a == 0 || b == 0) {
            return "Какой то из параметров не передан!";
        }
        return buildResultString(a, b, "-", calculatorService.minus(a, b));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b) {
        if (a == 0 || b == 0) {
            return "Какой то из параметров не передан!";
        }
        return buildResultString(a, b, "*", calculatorService.multiply(a, b));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2", required = false) Integer b) {
        if (a == 0 || b == 0) {
            return "Какой то из параметров не передан!";
        }
        if (b == 0) {
            return "Делить на ноль нельзя!";
        }
        return buildResultString(a, b, "/", calculatorService.divide(a, b));
    }

    private String buildResultString(int a,
                                     int b,
                                     String operation,
                                     Number result) {
        return String.format("%d %s %d = %s", a, b, operation, result);
    }
}
