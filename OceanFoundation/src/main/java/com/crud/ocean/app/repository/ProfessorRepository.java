package com.crud.ocean.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.ocean.app.model.Professor;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
    Optional<Professor> findByEmail(String email);
}
