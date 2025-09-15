package br.com.fiap.soat7.vendas.sales.service;

import br.com.fiap.soat7.vendas.sales.application.service.SaleService;
import br.com.fiap.soat7.vendas.sales.domain.entity.SaleEntity;
import br.com.fiap.soat7.vendas.sales.dto.PagamentoDTO;
import br.com.fiap.soat7.vendas.sales.dto.SaleRequest;
import br.com.fiap.soat7.vendas.sales.dto.SaleResponse;
import br.com.fiap.soat7.vendas.sales.infrastructure.repository.SaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SaleServiceTest {

    private SaleService saleService;
    private SaleRepository saleRepository;

    @BeforeEach
    void setUp() {
        saleRepository = mock(SaleRepository.class);
        saleService = new SaleService(saleRepository);
    }

    @Test
    void efetuarVenda_ShouldSaveSaleAndReturnResponse() {
        SaleRequest saleRequest = new SaleRequest();
        saleRequest.setCpf("12345678900");
        saleRequest.setVeiculoId(1L);

        ArgumentCaptor<SaleEntity> captor = ArgumentCaptor.forClass(SaleEntity.class);

        SaleResponse response = saleService.efetuarVenda(saleRequest);

        verify(saleRepository, times(1)).save(captor.capture());
        SaleEntity savedSale = captor.getValue();

        assertEquals("12345678900", savedSale.getCpf());
        assertEquals("pagamento_pendente", savedSale.getStatus());
        assertNotNull(response);
    }

    @Test
    void atualizarStatusPagamento_ShouldUpdateSaleStatus() {
        SaleEntity sale = new SaleEntity();
        sale.setId(1L);
        sale.setStatus("pagamento_pendente");

        when(saleRepository.findById(1L)).thenReturn(Optional.of(sale));

        PagamentoDTO pagamento = new PagamentoDTO();
        pagamento.setSaleId(1L);
        pagamento.setStatusPagamento("pago");

        saleService.atualizarStatusPagamento(pagamento);

        verify(saleRepository, times(1)).save(sale);
        assertEquals("pago", sale.getStatus());
    }
}
