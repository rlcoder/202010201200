package br.com.tst.service;

import java.util.List;

import br.com.tst.service.dto.VeiculoDTO;
import br.com.tst.service.enums.TipoRiscoEnum;
import br.com.tst.service.mapper.VeiculoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tst.domain.Veiculo;
import br.com.tst.repository.VeiculoRepository;

@Service
@Validated
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;
    @Autowired
    private VeiculoMapper veiculoMapper;

    public List<Veiculo> findAll() {
        return repository.findAll();
    }

    public List<VeiculoDTO> buscarPorClassificacaoRisco(TipoRiscoEnum tipoRiscoEnum) {
        if (TipoRiscoEnum.ALTO.equals(tipoRiscoEnum)) {
            return veiculoMapper.entidadeParaDTOs(repository.buscarVeiculosComRiscoAlto(), tipoRiscoEnum);
        } else if (TipoRiscoEnum.MEDIO.equals(tipoRiscoEnum)) {
            return veiculoMapper.entidadeParaDTOs(repository.buscarVeiculosComRiscoMedio(), tipoRiscoEnum);
        } else if (TipoRiscoEnum.BAIXO.equals(tipoRiscoEnum)) {
            return  veiculoMapper.entidadeParaDTOs(repository.buscarVeiculosComRiscoBaixo(), tipoRiscoEnum);
        } else {
            return veiculoMapper.entidadeParaDTOs(repository.findAll(), null);
        }
    }

    public Veiculo save(Veiculo veiculo) {
        return repository.save(veiculo);
    }




}
