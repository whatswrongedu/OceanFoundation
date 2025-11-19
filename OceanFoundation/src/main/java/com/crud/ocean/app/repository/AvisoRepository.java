package com.crud.ocean.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.ocean.app.model.Aviso;

@Repository
public interface AvisoRepository extends JpaRepository<Aviso, Integer> {
}
