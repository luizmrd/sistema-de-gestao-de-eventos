package com.luizmrd.database.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "local")
public class LocalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String endereco;
    private Boolean online;


    @OneToMany(mappedBy = "local")
    private List<EventoEntity> eventos = new ArrayList<>();
}
