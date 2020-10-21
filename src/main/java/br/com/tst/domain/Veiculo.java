package br.com.tst.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veiculo")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "marca", length = 50 )
    private String marca;
    @Column(name = "modelo", length = 50 )
    private String modelo;
    @Column(name = "ano")
    private Integer ano;
    @Column(name = "valor")
    private Float valor;
    
}
