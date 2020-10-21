package br.com.tst.service.mapper;

import br.com.tst.domain.Veiculo;
import br.com.tst.service.dto.VeiculoDTO;
import br.com.tst.service.enums.TipoRiscoEnum;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class VeiculoMapper {

    public VeiculoDTO entidadeParaDTO(Veiculo veiculo, TipoRiscoEnum tipoRiscoEnum) {
        return Objects.isNull(veiculo)? null : VeiculoDTO.builder()
                .id(veiculo.getId())
                .ano(veiculo.getAno())
                .marca(veiculo.getMarca())
                .modelo(veiculo.getModelo())
                .valor(veiculo.getValor())
                .classificacaoRisco(Objects.isNull(tipoRiscoEnum)? classificarRisco(veiculo.getAno()) : tipoRiscoEnum)
                .build();
    }


    public List<VeiculoDTO> entidadeParaDTOs(List<Veiculo> veiculoList, TipoRiscoEnum tipoRiscoEnum) {
        return veiculoList.stream()
                .filter(Objects::nonNull)
                .map(veiculo -> this.entidadeParaDTO(veiculo, tipoRiscoEnum))
                .collect(Collectors.toList());
    }

    public TipoRiscoEnum classificarRisco(Integer anoVeiculo) {
        if (Objects.isNull(anoVeiculo)) return null;

        if (anoVeiculo < 2010) {
            return TipoRiscoEnum.ALTO;
        } else if (anoVeiculo < 2015){
            return TipoRiscoEnum.MEDIO;
        } else {
            return  TipoRiscoEnum.BAIXO;
        }
    }
}
