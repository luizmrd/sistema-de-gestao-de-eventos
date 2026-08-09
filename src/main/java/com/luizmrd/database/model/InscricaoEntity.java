package com.luizmrd.database.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "inscricao")
public class InscricaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String status;

    @Column(name = "criado_em")
    private OffsetDateTime criadoEm;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventoEntity evento;


    @ManyToOne
    @JoinColumn(name = "tipo_ingresso")
    private TipoIngressoEntity tipoIngresso;





}
