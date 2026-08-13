package com.luizmrd.database.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tipo_ingresso")
public class TipoIngressoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventoEntity evento;

    @OneToMany(mappedBy = "tipoIngresso")
    private List<InscricaoEntity> inscricoes = new ArrayList<>();

}
