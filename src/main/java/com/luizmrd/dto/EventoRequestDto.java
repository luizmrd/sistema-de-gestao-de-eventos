package com.luizmrd.dto;

import com.luizmrd.database.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.*;

public class EventoRequestDto {

    @NotBlank(message = "O titulo é obrigatorio")
    private String titulo;
    @NotNull(message = "A data de inicio é obrigatoria")
    private OffsetDateTime dataInicio;
    @NotNull(message = "A data de fim é obrigatoria")
    private OffsetDateTime dataFim;
    @NotBlank(message = "O status é obrigatorio")
    private String status;
    @NotNull(message = "A capacidade no evento é obrigatoria")
    private Integer capacidade;
    @NotNull(message = "O local é obrigatorio")
    private UUID local;
    @NotEmpty(message = "Informe pelo menos uma categoria")
    private Set<UUID> categoria = new HashSet<>();


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

    public UUID getLocal() {
        return local;
    }

    public void setLocal(UUID local) {
        this.local = local;
    }

    public Set<UUID> getCategoria() {
        return categoria;
    }

    public void setCategoria(Set<UUID> categoria) {
        this.categoria = categoria;
    }
}
