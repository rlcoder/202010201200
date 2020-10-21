package br.com.tst.repository;

import br.com.tst.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query(value = "select v from Veiculo v where v.ano < 2010")
    List<Veiculo> buscarVeiculosComRiscoAlto();

    @Query(value = "select v from Veiculo v where v.ano >= 2010 and v.ano < 2015")
    List<Veiculo> buscarVeiculosComRiscoMedio();

    @Query(value = "select v from Veiculo v where v.ano >= 2015")
    List<Veiculo> buscarVeiculosComRiscoBaixo();

}
