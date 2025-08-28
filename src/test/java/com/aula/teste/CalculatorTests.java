package com.aula.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("2 - 1 = 1")
    void testeSubtracao() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtracao(2, 1));
    }

    @ParameterizedTest
    @CsvSource({
            "9, 3, 6",
            "100, 100, 0",
            "51, 49, 2"
    })
    void subtracao(int n1, int n2, int result) {
        Calculator calculator = new Calculator();
        assertEquals(result, calculator.subtracao(n1, n2),
                () -> n1 + " - " + n2 + " é igual " + result);
    }
}