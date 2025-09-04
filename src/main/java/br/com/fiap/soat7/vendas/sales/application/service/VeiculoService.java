package br.com.fiap.soat7.vendas.sales.application.service;

import br.com.fiap.soat7.vendas.sales.application.port.usecase.VeiculoUseCase;
import br.com.fiap.soat7.vendas.sales.dto.VeiculoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService implements VeiculoUseCase {

    @Override
    public List<VeiculoResponse> listarVeiculosDisponiveis() {
        return null;
    }

    @Override
    public List<VeiculoResponse> listarVeiculosVendidos() {
        return null;
    }
}
