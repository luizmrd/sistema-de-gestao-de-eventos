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
    private List<InscricaoEntity> inscricao = new ArrayList<>();


    public UsuarioEntity(UUID id, String cpf, String email, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
    }

    public static Builder builder(){
        return new Builder();
    }


    public UsuarioEntity(Builder builder) {
        this.cpf = builder.cpf;
        this.email = builder.email;
        this.nome = builder.nome;
    }
    public static class Builder{

        private String nome;
        private String email;
        private String cpf;

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }public Builder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }

        public UsuarioEntity build(){
            return new UsuarioEntity(this);
        }
    }



    public UsuarioEntity(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
