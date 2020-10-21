package br.com.tst.service.dto;

import br.com.tst.service.enums.TipoRiscoEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VeiculoDTO {

    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private Float valor;
    private TipoRiscoEnum classificacaoRisco;
}
