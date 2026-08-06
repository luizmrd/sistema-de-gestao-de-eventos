package com.luizmrd.database.repository;

import com.luizmrd.database.model.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEventosRepository extends JpaRepository<EventoEntity, UUID> {
}
