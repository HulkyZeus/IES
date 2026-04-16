package com.example.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void debeSumarCorrectamente() {
        double resultado = calculatorService.sumar(10, 5);
        assertEquals(15.0, resultado);
    }

    @Test
    void debeRestarCorrectamente() {
        double resultado = calculatorService.restar(10, 5);
        assertEquals(5.0, resultado);
    }

    @Test
    void debeMultiplicarCorrectamente() {
        double resultado = calculatorService.multiplicar(10, 5);
        assertEquals(50.0, resultado);
    }

    @Test
    void debeDividirCorrectamente() {
        double resultado = calculatorService.dividir(10, 5);
        assertEquals(2.0, resultado);
    }

    @Test
    void debeLanzarExcepcionCuandoDividePorCero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculatorService.dividir(10, 0)
        );

        assertEquals("No se puede dividir por cero", exception.getMessage());
    }
}