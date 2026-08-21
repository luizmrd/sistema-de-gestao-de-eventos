package com.luizmrd.controller;

import com.luizmrd.database.model.EventoEntity;
import com.luizmrd.dto.EventoRequestDto;
import com.luizmrd.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/evento")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEvento(@Valid @RequestBody EventoRequestDto eventoRequestDto){
        eventoService.criarEvento(eventoRequestDto);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EventoEntity buscarEvento(@PathVariable UUID id){
        return eventoService.buscarUsuario(id);
    }

}
