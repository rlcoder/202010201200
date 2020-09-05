package br.com.tst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tst.domain.Veiculo;
import br.com.tst.repository.VeiculoRepository;

@Service
@Validated
public class VeiculoService {

    @Autowired private VeiculoRepository repository;

    public List<Veiculo> findAll() {
        return (List<Veiculo>) repository.findAll();
    }

    public Veiculo save(Veiculo veiculo) {
        return repository.save(veiculo);
    }

}
