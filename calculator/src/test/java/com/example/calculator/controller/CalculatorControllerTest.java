package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CalculatorControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        CalculatorService service = new CalculatorService();
        CalculatorController controller = new CalculatorController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void debeSumarCorrectamente() throws Exception {
        mockMvc.perform(get("/api/calculator/sumar")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operacion").value("sumar"))
                .andExpect(jsonPath("$.resultado").value(15.0));
    }

    @Test
    void debeRetornarBadRequestCuandoDividePorCero() throws Exception {
        mockMvc.perform(get("/api/calculator/dividir")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("No se puede dividir por cero"));
    }
}