package br.com.fiap.soat7.vendas.sales.client;

import br.com.fiap.soat7.vendas.sales.dto.VeiculoResponse;
import br.com.fiap.soat7.vendas.sales.infrastructure.client.VeiculoClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VeiculoClientTest {

    private VeiculoClient veiculoClient;
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = mock(RestTemplate.class);
        veiculoClient = new VeiculoClient(restTemplate);
        ReflectionTestUtils.setField(veiculoClient, "veiculoServiceUrl", "http://mock-url");
    }

    @Test
    void getAllVehicles_ShouldReturnListOfVehicles() {
        VeiculoResponse[] mockResponse = {new VeiculoResponse()};
        when(restTemplate.getForEntity("http://mock-url", VeiculoResponse[].class))
                .thenReturn(new org.springframework.http.ResponseEntity<>(mockResponse, org.springframework.http.HttpStatus.OK));

        List<VeiculoResponse> vehicles = veiculoClient.getAllVehicles();

        assertNotNull(vehicles);
        assertEquals(1, vehicles.size());
    verify(restTemplate, times(1)).getForEntity("http://mock-url", VeiculoResponse[].class);
    }

    @Test
    void getAllVehicles_ShouldReturnEmptyListOnException() {
        when(restTemplate.getForEntity("http://mock-url", VeiculoResponse[].class))
                .thenThrow(new RuntimeException("Error"));

        List<VeiculoResponse> vehicles = veiculoClient.getAllVehicles();

        assertNotNull(vehicles);
        assertTrue(vehicles.isEmpty());
        verify(restTemplate, times(1)).getForEntity("http://mock-url", VeiculoResponse[].class);
    }
}