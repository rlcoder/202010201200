package br.com.tst.web.rest;

import java.util.List;

import br.com.tst.service.dto.VeiculoDTO;
import br.com.tst.service.enums.TipoRiscoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.tst.domain.Veiculo;
import br.com.tst.service.VeiculoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/veiculo")
public class VeiculoRestController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<Veiculo> findAll() {
        return service.findAll();
    }

    @GetMapping("/listar/classificacao-risco/{risco}")
    public List<VeiculoDTO> buscarPorClassificacaoRisco(@PathVariable("risco") TipoRiscoEnum classificao) {
        return service.buscarPorClassificacaoRisco(classificao);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo create(@RequestBody Veiculo veiculo) {
    	veiculo = service.save(veiculo);
        return veiculo;
    }

}
