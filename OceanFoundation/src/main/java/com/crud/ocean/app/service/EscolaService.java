package com.crud.ocean.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ocean.app.model.Aluno;
import com.crud.ocean.app.model.Aviso;
import com.crud.ocean.app.model.Disciplina;
import com.crud.ocean.app.model.Falta;
import com.crud.ocean.app.model.Professor;
import com.crud.ocean.app.repository.AlunoRepository;
import com.crud.ocean.app.repository.AvisoRepository;
import com.crud.ocean.app.repository.DisciplinaRepository;
import com.crud.ocean.app.repository.FaltaRepository;
import com.crud.ocean.app.repository.ProfessorRepository;

@Service
public class EscolaService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private FaltaRepository faltaRepository;
    @Autowired
    private AvisoRepository avisoRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Aluno buscarAlunoEmail(String email) {
        return alunoRepository.findByEmail(email).orElse(null);
    }

    public Professor buscarProfessorEmail(String email) {
        return professorRepository.findByEmail(email).orElse(null);
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public List<Aviso> listarAvisos() {
        return avisoRepository.findAll();
    }

    public List<Falta> buscarFalta(Aluno aluno) {
        return faltaRepository.findByAluno(aluno);
    }
    
    public void justificarFalta(int idFalta, String justificativa){
        Optional<Falta> faltOptional = faltaRepository.findById(idFalta);
        if (faltOptional.isPresent()) {
            Falta falta = faltOptional.get();
            falta.setJustificativa(justificativa);
            faltaRepository.save(falta);
        }
    }

    // --------------------------------------------------------- agr o professor

    public List<Falta> listarTodaFaltas(){
        return faltaRepository.findAll();
    }

    public void abonarFaltas(int idFalta){
        Optional<Falta> faltaOptional = faltaRepository.findById(idFalta);
        if (faltaOptional.isPresent()) {
            Falta falta = faltaOptional.get();
            falta.setAbonada(true);
            faltaRepository.save(falta);
        }
    }

    public void salvarAviso(Aviso aviso, String emailProfessor){
        Professor prof = buscarProfessorEmail(emailProfessor);
        if (prof != null){
            aviso.setProfessor(prof);
            avisoRepository.save(aviso);
        }
    }

    public void excluirAviso(int idAviso){
        avisoRepository.deleteById(idAviso);
    }

}
