package com.luizmrd.database.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_eventos")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String titulo;
    @Column(name = "data_inicio")
    private OffsetDateTime dataInicio;
    @Column(name = "data_fim")
    private OffsetDateTime dataFim;
    private Integer capacidade;
}
