package br.com.tst.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private Float valor;
    
}
