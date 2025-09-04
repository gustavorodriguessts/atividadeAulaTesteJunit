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

    @Test
    @DisplayName("2 * 1 = 2")
    void testeMultiplicacao() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.multiplicacao(2,1));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1 , 0",
            "1, 2, 2",
            "100, 100, 10000"
    })
    void multiplicacao(int n1, int n2, int result) {
        Calculator calculator = new Calculator();
        assertEquals(result, calculator.multiplicacao(n1, n2),
                () -> n1 + " * " + n2 + " é igual " + result);
    }

    @Test
    @DisplayName("4 / 2 = 2")
    void testeDivisao() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divisao(4, 2));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1, 2",
            "20, 5, 4",
            "100, 100, 1"
    })
    void divisao(int n1, int n2, int result) {
        Calculator calculator = new Calculator();
        assertEquals(result, calculator.divisao(n1, n2),
            () -> n1 + " / " + n2 + " é igual " + result);
    }
}