package br.com.fiap.soat7.vendas.sales.infrastructure.controller;

import br.com.fiap.soat7.vendas.sales.application.port.usecase.SaleUseCase;
import br.com.fiap.soat7.vendas.sales.dto.PagamentoDTO;
import br.com.fiap.soat7.vendas.sales.dto.SaleRequest;
import br.com.fiap.soat7.vendas.sales.dto.SaleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleUseCase useCase;

    @PostMapping
    public SaleResponse efetuarVenda(@RequestBody SaleRequest dto) {
        return useCase.efetuarVenda(dto);
    }

    @PostMapping("/webhook")
    public ResponseEntity<Void> atualizarStatusPagamento(@RequestBody PagamentoDTO dto) {
        useCase.atualizarStatusPagamento(dto);
        return ResponseEntity.ok().build();
    }
}
