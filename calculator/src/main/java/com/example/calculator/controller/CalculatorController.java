package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/sumar")
    public ResponseEntity<Map<String, Object>> sumar(
            @RequestParam double a,
            @RequestParam double b) {

        double resultado = calculatorService.sumar(a, b);
        return ResponseEntity.ok(Map.of(
                "id", "1234",
                "operacion", "sumar",
                "a", a,
                "b", b,
                "resultado", resultado
        ));
    }

    @GetMapping("/restar")
    public ResponseEntity<Map<String, Object>> restar(
            @RequestParam double a,
            @RequestParam double b) {

        double resultado = calculatorService.restar(a, b);
        return ResponseEntity.ok(Map.of(
                "operacion", "restar",
                "a", a,
                "b", b,
                "resultado", resultado
        ));
    }

    @GetMapping("/multiplicar")
    public ResponseEntity<Map<String, Object>> multiplicar(
            @RequestParam double a,
            @RequestParam double b) {

        double resultado = calculatorService.multiplicar(a, b);
        return ResponseEntity.ok(Map.of(
                "operacion", "multiplicar",
                "a", a,
                "b", b,
                "resultado", resultado
        ));
    }

    @GetMapping("/dividir")
    public ResponseEntity<?> dividir(
            @RequestParam double a,
            @RequestParam double b) {

        try {
            double resultado = calculatorService.dividir(a, b);
            return ResponseEntity.ok(Map.of(
                    "operacion", "dividir",
                    "a", a,
                    "b", b,
                    "resultado", resultado
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}