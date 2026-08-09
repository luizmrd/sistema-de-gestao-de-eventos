package com.luizmrd.database.repository;

import com.luizmrd.database.model.EventoEntity;
import com.luizmrd.database.model.LocalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ILocalRepository extends JpaRepository<LocalEntity, UUID> {
}
