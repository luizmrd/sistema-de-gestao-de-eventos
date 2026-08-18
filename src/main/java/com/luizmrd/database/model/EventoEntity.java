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


    private EventoEntity(Builder builder) {
        this.id = builder.id;
        this.titulo = builder.titulo;
        this.dataInicio = builder.dataInicio;
        this.dataFim = builder.dataFim;
        this.status = builder.status;
        this.capacidade = builder.capacidade;
        this.organizador = builder.organizador;
        this.local = builder.local;

    }

    public EventoEntity() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID id;
        private String titulo;
        private OffsetDateTime dataInicio;
        private OffsetDateTime dataFim;
        private String status;
        private Integer capacidade;
        private UsuarioEntity organizador;
        private List<InscricaoEntity> inscricoes = new ArrayList<>();
        private List<TipoIngressoEntity> tipoIngresso = new ArrayList<>();
        private LocalEntity local;

        private Set<CategoriaEntity> categoria = new HashSet<>();



        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder dataInicio(OffsetDateTime dataInicio) {
            this.dataInicio = dataInicio;
            return this;
        }

        public Builder dataFim(OffsetDateTime dataFim) {
            this.dataFim = dataFim;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder capacidade(Integer capacidade) {
            this.capacidade = capacidade;
            return this;
        }

        public Builder organizador(UsuarioEntity organizador) {
            this.organizador = organizador;
            return this;
        }
        public Builder inscricoes(List<InscricaoEntity> inscricoes) {
            this.inscricoes = inscricoes;
            return this;
        }

        public Builder tipoIngresso(List<TipoIngressoEntity> tipoIngresso) {
            this.tipoIngresso = tipoIngresso;
            return this;
        }


        public Builder local(LocalEntity local) {
            this.local = local;
            return this;
        }
        public Builder categoria(Set<CategoriaEntity> categoria) {
            this.categoria = categoria;
            return this;
        }

        public EventoEntity build() {
            return new EventoEntity(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(OffsetDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}
