package br.com.fiap.soat7.vendas.sales.dto;

import br.com.fiap.soat7.vendas.sales.domain.entity.SaleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponse {

    private Long id;
    private String cpf;
    private LocalDateTime data;
    private String status;
    private Long veiculoId;
    public SaleResponse(SaleEntity sale) {
        this.id = sale.getId();
        this.cpf = sale.getCpf();
        this.data = sale.getData();
        this.status = sale.getStatus();
        this.veiculoId = sale.getVeiculoId();
    }
}
