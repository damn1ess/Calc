package pro.sky.java.course2.calculator.calculatorService;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceParameterizedTest {

    CalculatorService calculatorService = new CalculatorService();
    private int result;


    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void sumTest(int a, int b) {
        result = calculatorService.sum(a, b);
        int expected = (a + b);
        assertEquals(expected, result);
        System.out.print(String.format("%d + %d = %d \n", a, b, result));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void minusTest(int a, int b) {
        result = calculatorService.minus(a, b);
        int expected = (a - b);
        assertEquals(expected, result);
        System.out.print(String.format("%d - %d = %d \n", a, b, result));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void multiplyTest(int a, int b) {
        result = calculatorService.multiply(a, b);
        int expected = (a * b);
        assertEquals(expected, result);
        System.out.print(String.format("%d * %d = %d \n", a, b, result));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void divideTest(int a, int b) {
        double result = calculatorService.divide(a, b);
        double expected = (double) a / (double) b;
        assertEquals(expected, result);
        System.out.println(a + " / " + b + " = " + result);
    }

    public static Stream<Arguments> provideParamsForTest() {
        return Stream.of(
                Arguments.of(9, 5),
                Arguments.of(10, 12),
                Arguments.of(2, 7)
        );
    }
}
