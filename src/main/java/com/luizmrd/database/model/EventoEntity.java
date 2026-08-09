package com.luizmrd.database.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.*;

@Entity
@Table(name = "evento")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 200)
    private String titulo;

    @Column(name = "data_inicio")
    private OffsetDateTime dataInicio;

    @Column(name = "data_fim")
    private OffsetDateTime dataFim;

    private String status;
    private Integer capacidade;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private UsuarioEntity organizador;

    @OneToMany(mappedBy = "evento")
    private List<InscricaoEntity> inscricoes = new ArrayList<>();

    @OneToMany(mappedBy = "evento")
    private List<TipoIngressoEntity> tipoIngresso = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "local_id")
    private LocalEntity local;

    @ManyToMany
    @JoinTable(
            name = "evento_categoria",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<CategoriaEntity> categoria = new HashSet<>();


}
