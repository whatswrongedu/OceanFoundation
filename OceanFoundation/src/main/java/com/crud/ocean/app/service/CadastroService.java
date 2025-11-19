package com.crud.ocean.app.service;

import com.crud.ocean.app.model.Aluno;
import com.crud.ocean.app.model.Professor;
import com.crud.ocean.app.repository.AlunoRepository;
import com.crud.ocean.app.repository.ProfessorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;
    private final BCryptPasswordEncoder encoder; 


    public CadastroService(
        AlunoRepository alunoRepository, 
        ProfessorRepository professorRepository, 
        BCryptPasswordEncoder encoder
    ) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.encoder = encoder;
    }

    public void cadastrarAluno(Aluno aluno) {
        aluno.setSenha(encoder.encode(aluno.getSenha()));
        alunoRepository.save(aluno);
    }

    public void cadastrarProfessor(Professor professor) {
        professor.setSenha(encoder.encode(professor.getSenha()));
        professorRepository.save(professor);
    }
}