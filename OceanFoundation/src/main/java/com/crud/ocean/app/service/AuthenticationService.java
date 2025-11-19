package com.crud.ocean.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crud.ocean.app.model.Aluno;
import com.crud.ocean.app.model.Professor;
import com.crud.ocean.app.repository.AlunoRepository;
import com.crud.ocean.app.repository.ProfessorRepository;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Optional<Aluno> alunoOptional = alunoRepository.findByEmail(email);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            return User.builder()
            .username(aluno.getEmail())
            .password(aluno.getSenha())
            .roles("ALUNO")
            .build();
        }
        Optional<Professor> professorOptional = professorRepository.findByEmail(email);
        if (professorOptional.isPresent()) {
            Professor professor = professorOptional.get();
            return User.builder()
            .username(professor.getEmail())
            .password(professor.getSenha())
            .roles("PROFESSOR")
            .build();
        }
        throw new UsernameNotFoundException("Email não encontrado" + email);
    }

}
