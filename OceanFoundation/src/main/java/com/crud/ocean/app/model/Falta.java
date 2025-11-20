package com.crud.ocean.app.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Falta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFalta;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Disciplina disciplina;
    private LocalDate data;
    private String justificativa;
    private boolean abonada = false;

    public Falta() {

    }


    public int getIdFalta() {
        return this.idFalta;
    }

    public void setIdFalta(int idFalta) {
        this.idFalta = idFalta;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getJustificativa() {
        return this.justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public boolean isAbonada() {
        return this.abonada;
    }

    public boolean getAbonada() {
        return this.abonada;
    }

    public void setAbonada(boolean abonada) {
        this.abonada = abonada;
    }

}