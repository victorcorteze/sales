package br.com.fiap.soat7.vendas.sales.application.service;

import br.com.fiap.soat7.vendas.sales.application.port.usecase.SaleUseCase;
import br.com.fiap.soat7.vendas.sales.dto.PagamentoDTO;
import br.com.fiap.soat7.vendas.sales.dto.SaleRequest;
import br.com.fiap.soat7.vendas.sales.dto.SaleResponse;
import br.com.fiap.soat7.vendas.sales.domain.entity.SaleEntity;
import br.com.fiap.soat7.vendas.sales.infrastructure.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SaleService implements SaleUseCase {

    private final SaleRepository repository;

    @Override
    public SaleResponse efetuarVenda(SaleRequest saleRequest) {

        SaleEntity sale = new SaleEntity();
        sale.setCpf(saleRequest.getCpf());
        sale.setData(LocalDateTime.now());
        sale.setVeiculoId(saleRequest.getVeiculoId());
        sale.setStatus("pagamento_pendente");

        repository.save(sale);

        return new SaleResponse(sale);
    }

    @Override
    public void atualizarStatusPagamento(PagamentoDTO pagamento) {
        SaleEntity sale = repository.findById(pagamento.getSaleId())
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        sale.setStatus(pagamento.getStatusPagamento());
        repository.save(sale);
    }

}
