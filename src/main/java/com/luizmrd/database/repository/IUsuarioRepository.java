package com.luizmrd.database.repository;

import com.luizmrd.database.model.EventoEntity;
import com.luizmrd.database.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {


    Optional<UsuarioEntity> findByCpf(String email);
}
