package br.com.fiap.soat7.vendas.sales.application.port.usecase;

import br.com.fiap.soat7.vendas.sales.dto.VeiculoResponse;

import java.util.List;

public interface VeiculoUseCase {

    List<VeiculoResponse> listarVeiculosDisponiveis();
    List<VeiculoResponse> listarVeiculosVendidos();
}
