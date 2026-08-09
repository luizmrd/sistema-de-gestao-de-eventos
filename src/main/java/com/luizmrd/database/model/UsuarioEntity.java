package com.luizmrd.database.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 150)
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(length = 12,unique = true)
    private String cpf;

    @OneToMany(mappedBy = "organizador")
    private List<EventoEntity> eventosOrganizados = new ArrayList<>();

    @OneToMany
    private Set<EventoEntity> evento = new HashSet<>();

    @OneToMany
    private List<InscricaoEntity> inscricao = new ArrayList<>();

}
