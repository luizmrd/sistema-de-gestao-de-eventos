package com.luizmrd.service;

import com.luizmrd.database.model.UsuarioEntity;
import com.luizmrd.database.repository.IUsuarioRepository;
import com.luizmrd.dto.UsuarioRequestDto;
import com.luizmrd.exception.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    public void criarUsuario(UsuarioRequestDto usuarioRequestDto) throws BadRequestException {

        UsuarioEntity usuario = usuarioRepository.findByCpf(usuarioRequestDto.getEmail())
                        .orElse(null);
            if(usuario != null){
                throw new BadRequestException("Cpf em uso");
            }
            usuarioRepository.save(
                    UsuarioEntity.builder()
                            .nome(usuarioRequestDto.getNome())
                            .email(usuarioRequestDto.getEmail())
                            .cpf(usuarioRequestDto.getCpf())
                            .build()
            );

    }
}
