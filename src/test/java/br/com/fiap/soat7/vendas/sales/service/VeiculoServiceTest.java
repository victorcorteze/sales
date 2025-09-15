package br.com.fiap.soat7.vendas.sales.service;

import br.com.fiap.soat7.vendas.sales.application.service.VeiculoService;
import br.com.fiap.soat7.vendas.sales.dto.VeiculoResponse;
import br.com.fiap.soat7.vendas.sales.infrastructure.client.VeiculoClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class VeiculoServiceTest {
    private VeiculoService veiculoService;
    private VeiculoClient veiculoClient;

    @BeforeEach
    void setUp() {
        veiculoClient = mock(VeiculoClient.class);
        veiculoService = new VeiculoService(veiculoClient);
    }

    @Test
    void listarVeiculosDisponiveis_ShouldReturnAvailableVehicles() {
        VeiculoResponse veiculo1 = new VeiculoResponse();
        veiculo1.setStatus("estoque");
        VeiculoResponse veiculo2 = new VeiculoResponse();
        veiculo2.setStatus("vendido");

        when(veiculoClient.getAllVehicles()).thenReturn(List.of(veiculo1, veiculo2));

        List<VeiculoResponse> disponiveis = veiculoService.listarVeiculosDisponiveis();

        assertEquals(1, disponiveis.size());
        assertEquals("estoque", disponiveis.get(0).getStatus());
        verify(veiculoClient, times(1)).getAllVehicles();
    }

    @Test
    void listarVeiculosVendidos_ShouldReturnSoldVehicles() {
        VeiculoResponse veiculo1 = new VeiculoResponse();
        veiculo1.setStatus("estoque");
        VeiculoResponse veiculo2 = new VeiculoResponse();
        veiculo2.setStatus("vendido");

        when(veiculoClient.getAllVehicles()).thenReturn(List.of(veiculo1, veiculo2));

        List<VeiculoResponse> vendidos = veiculoService.listarVeiculosVendidos();

        assertEquals(1, vendidos.size());
        assertEquals("vendido", vendidos.get(0).getStatus());
        verify(veiculoClient, times(1)).getAllVehicles();
    }
}