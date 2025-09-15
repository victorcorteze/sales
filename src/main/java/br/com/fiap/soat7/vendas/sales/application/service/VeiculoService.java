package br.com.fiap.soat7.vendas.sales.application.service;

import br.com.fiap.soat7.vendas.sales.application.port.usecase.VeiculoUseCase;
import br.com.fiap.soat7.vendas.sales.dto.VeiculoResponse;
import br.com.fiap.soat7.vendas.sales.infrastructure.client.VeiculoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService implements VeiculoUseCase {

    private final VeiculoClient client;

    @Override
    public List<VeiculoResponse> listarVeiculosDisponiveis() {
        return this.client.getAllVehicles().stream().filter(v -> v.getStatus().equals("estoque")).toList();
    }

    @Override
    public List<VeiculoResponse> listarVeiculosVendidos() {
        return this.client.getAllVehicles().stream().filter(v -> v.getStatus().equals("vendido")).toList();
    }
}
