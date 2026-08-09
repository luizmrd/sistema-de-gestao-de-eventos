package com.luizmrd.controller;

import com.luizmrd.dto.UsuarioRequestDto;
import com.luizmrd.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public void criarUsuario(@RequestBody UsuarioRequestDto usuarioRequestDto){
        usuarioService.criarUsuario(usuarioRequestDto);
    }

}
