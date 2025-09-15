package br.com.fiap.soat7.vendas.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VeiculoResponse {

    private Long id;
    private String marca;
    private String modelo;
    private String ano;
    private String cor;
    private BigDecimal preco;
    private String status;
}
