package com.luizmrd.controller;

import com.luizmrd.dto.UsuarioRequestDto;
import com.luizmrd.exception.BadRequestException;
import com.luizmrd.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarUsuario(@RequestBody UsuarioRequestDto usuarioRequestDto) throws BadRequestException {
        usuarioService.criarUsuario(usuarioRequestDto);
    }

}
