package com.crud.ocean.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.ocean.app.model.Aluno;
import com.crud.ocean.app.model.Falta;


@Repository
public interface FaltaRepository extends JpaRepository<Falta, Integer> {
        List<Falta> findByAluno(Aluno aluno);
}
