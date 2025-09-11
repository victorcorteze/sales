package br.com.fiap.soat7.vendas.sales.controller;
import br.com.fiap.soat7.vendas.sales.application.port.usecase.VeiculoUseCase;
import br.com.fiap.soat7.vendas.sales.dto.VeiculoResponse;
import br.com.fiap.soat7.vendas.sales.infrastructure.controller.VeiculoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VeiculoController.class)
class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VeiculoUseCase veiculoUseCase;

    @Test
    void listarVeiculosDisponiveis_ShouldReturnListOfVehicles() throws Exception {
        VeiculoResponse response = new VeiculoResponse();
        when(veiculoUseCase.listarVeiculosDisponiveis()).thenReturn(List.of(response));

        mockMvc.perform(get("/veiculo/disponiveis"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void listarVeiculosVendidos_ShouldReturnEmptyList() throws Exception {
        when(veiculoUseCase.listarVeiculosVendidos()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/veiculo/vendidos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));
    }
}