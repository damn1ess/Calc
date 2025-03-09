package pro.sky.java.course2.calculator.calculatorService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    void sum() {
        assertEquals(4, calculatorService.sum(2, 2));
        assertEquals(0, calculatorService.sum(-2, 2));
    }

    @Test
    void minus() {
        assertEquals(3, calculatorService.minus(5, 2));
        assertEquals(4, calculatorService.minus(2, -2));
    }

    @Test
    void multiply() {
        assertEquals(6, calculatorService.multiply(3, 2));
        assertEquals(10, calculatorService.multiply(5, 2));
    }

    @Test
    void divide() {
        assertEquals(1, calculatorService.divide(2, 2));
        assertEquals(5, calculatorService.divide(10, 2));
    }
}