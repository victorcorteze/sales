package br.com.fiap.soat7.vendas.sales.infrastructure.client;

import br.com.fiap.soat7.vendas.sales.dto.VeiculoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class VeiculoClient {

    private final RestTemplate restTemplate;
    @Value("${vehicle.service.url:localhost}")
    private String veiculoServiceUrl;

    public VeiculoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<VeiculoResponse> getAllVehicles() {
        String url = veiculoServiceUrl;
        log.info("Fetching vehicles from URL: {}", url);
        try {
            List<VeiculoResponse> response = List.of(restTemplate.getForEntity(url, VeiculoResponse[].class).getBody());
            log.info("Response from vehicle service: {}", response);
            return response;
        } catch (Exception e) {
            log.error("Error while fetching vehicles: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

}
