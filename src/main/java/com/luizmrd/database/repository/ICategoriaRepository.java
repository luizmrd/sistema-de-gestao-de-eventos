package com.luizmrd.database.repository;

import com.luizmrd.database.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, UUID> {
}
