package br.com.fiap.soat7.vendas.sales.infrastructure.controller;

import br.com.fiap.soat7.vendas.sales.application.port.usecase.VeiculoUseCase;
import br.com.fiap.soat7.vendas.sales.dto.VeiculoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoUseCase veiculoUseCase;

    @GetMapping("/disponiveis")
    public List<VeiculoResponse> listarVeiculosDisponiveis() {
        return veiculoUseCase.listarVeiculosDisponiveis();
    }

    @GetMapping("/vendidos")
    public List<VeiculoResponse> listarVeiculosVendidos() {
        return veiculoUseCase.listarVeiculosVendidos();
    }

}
