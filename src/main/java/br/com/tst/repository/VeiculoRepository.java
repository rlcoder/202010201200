package br.com.tst.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tst.domain.Veiculo;

@Component
public class VeiculoRepository{
	
	@Autowired 
	private VeiculoTable table;
	
	public Veiculo save ( Veiculo veiculo ) {
		VeiculoTable.getInstance().getRecords().add( veiculo );
		int i = VeiculoTable.getInstance().getRecords().indexOf( veiculo );
		Long id = Long.parseLong( String.valueOf( i ) );
		veiculo.setId(id);
		return veiculo; 
		
	}

	public void delete ( Veiculo veiculo ) {
	}

	public Veiculo update ( Veiculo veiculo ) {
		return null;
	}
	
	public List<Veiculo> findAll ( ) {
		return VeiculoTable.getInstance().getRecords();
	}
	
}
