package br.com.fiap.soat7.vendas.sales.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest {

    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("veiculo_id")
    private Long veiculoId;

}
