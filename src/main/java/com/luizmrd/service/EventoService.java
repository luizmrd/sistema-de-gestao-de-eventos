package com.luizmrd.service;

import com.luizmrd.database.model.CategoriaEntity;
import com.luizmrd.database.model.EventoEntity;
import com.luizmrd.database.model.LocalEntity;
import com.luizmrd.database.repository.ICategoriaRepository;
import com.luizmrd.database.repository.IEventoRepository;
import com.luizmrd.database.repository.ILocalRepository;
import com.luizmrd.dto.EventoRequestDto;
import com.luizmrd.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class EventoService {

    private final IEventoRepository eventoRepository;

    private final ILocalRepository localRepository;
    private final ICategoriaRepository categoriaRepository;


    public EventoService(IEventoRepository eventoRepository, ILocalRepository localRepository, ICategoriaRepository categoriaRepository){
        this.eventoRepository = eventoRepository;
        this.localRepository = localRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public void criarEvento(EventoRequestDto eventoDto){
        LocalEntity local = localRepository.findById(eventoDto.getLocal())
                .orElseThrow(() ->
                        new BadRequestException("Local invalido")
                );

        Set<CategoriaEntity> categorias = new HashSet<>();
        for(UUID categoriaId :eventoDto.getCategoria()){
            CategoriaEntity categoria = categoriaRepository.findById(categoriaId)
                    .orElseThrow(() ->
                            new BadRequestException("Categoria não encontrada: " + categoriaId)

                    );
            categorias.add(categoria);
        }

        EventoEntity evento = EventoEntity.builder()
                .titulo(eventoDto.getTitulo())
                .dataInicio(eventoDto.getDataInicio())
                .dataFim(eventoDto.getDataFim())
                .status(eventoDto.getStatus())
                .capacidade(eventoDto.getCapacidade())
                .local(local)
                .categoria(categorias)
                .build();

    }
    public EventoEntity buscarUsuario(UUID id){
        EventoEntity evento = eventoRepository.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Evento não encontrado!")
                );

        return evento;
    }





}
