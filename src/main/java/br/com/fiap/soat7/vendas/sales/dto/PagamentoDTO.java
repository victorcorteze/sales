package br.com.fiap.soat7.vendas.sales.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {

    @JsonProperty("sale_id")
    private Long saleId;
    @JsonProperty("status_pagamento")
    private String statusPagamento;
}
