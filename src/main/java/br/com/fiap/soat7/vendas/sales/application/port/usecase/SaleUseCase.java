package br.com.fiap.soat7.vendas.sales.application.port.usecase;

import br.com.fiap.soat7.vendas.sales.dto.PagamentoDTO;
import br.com.fiap.soat7.vendas.sales.dto.SaleRequest;
import br.com.fiap.soat7.vendas.sales.dto.SaleResponse;

public interface SaleUseCase {

    SaleResponse efetuarVenda(SaleRequest saleRequest);
    void atualizarStatusPagamento(PagamentoDTO webhookPagamento);
}