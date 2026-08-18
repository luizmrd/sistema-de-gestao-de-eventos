package com.luizmrd.controller;

import com.luizmrd.database.model.UsuarioEntity;
import com.luizmrd.dto.UsuarioRequestDto;
import com.luizmrd.exception.BadRequestException;
import com.luizmrd.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarUsuario(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) throws BadRequestException {
        usuarioService.criarUsuario(usuarioRequestDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UsuarioEntity buscarUsuario(@PathVariable UUID id){
        return usuarioService.buscarUsuario(id);
    }

}
