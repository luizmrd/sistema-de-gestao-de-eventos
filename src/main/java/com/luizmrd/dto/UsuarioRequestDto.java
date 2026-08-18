package com.luizmrd.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UsuarioRequestDto {

    @NotBlank(message = "O nome é obrigatorio")
    private String nome;
    @Email(message = "E-mail inválido")
    @NotBlank(message = "O email é obrigatorio")
    private String email;
    @NotNull(message = "O CPF é obrigatorio")
    @Pattern(
            regexp = "\\d{11}",
            message = "CPF deve conter 11 números"
    )
    private String cpf;

    public UsuarioRequestDto(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
    public UsuarioRequestDto(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
