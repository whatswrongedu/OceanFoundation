package com.crud.ocean.app.controller;

import com.crud.ocean.app.model.Aluno;
import com.crud.ocean.app.model.Professor;
import com.crud.ocean.app.model.Aviso;
import com.crud.ocean.app.model.Disciplina;
import com.crud.ocean.app.model.Falta;
import com.crud.ocean.app.service.CadastroService;
import com.crud.ocean.app.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private CadastroService cadastroService;

    @Autowired
    private EscolaService escolaService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ALUNO"))) {
            return "redirect:/aluno/dashboard";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_PROFESSOR"))) {
            return "redirect:/professor/dashboard";
        }
        return "redirect:/login";
    }

    // --- ÁREA DO ALUNO ---
    @GetMapping("/aluno/dashboard")
    public String dashboardAluno(Model model, Authentication auth) {
        Aluno aluno = escolaService.buscarAlunoEmail(auth.getName());

        List<Falta> faltas = escolaService.buscarFalta(aluno);
        List<Disciplina> disciplinas = escolaService.listarDisciplinas();
        List<Aviso> avisos = escolaService.listarAvisos();

        model.addAttribute("aluno", aluno);
        model.addAttribute("faltas", faltas);
        model.addAttribute("disciplinas", disciplinas);
        model.addAttribute("avisos", avisos);

        return "aluno-dashboard";
    }

    @PostMapping("/aluno/falta/justificar")
    public String justificarFalta(@RequestParam int idFalta, @RequestParam String justificativa) {
        escolaService.justificarFalta(idFalta, justificativa);
        return "redirect:/aluno/dashboard";
    }

    // --- ÁREA DO PROFESSOR ---
    @GetMapping("/professor/dashboard")
    public String dashboardProfessor(Model model, Authentication auth) {
        Professor professor = escolaService.buscarProfessorEmail(auth.getName());

        List<Falta> todasFaltas = escolaService.listarTodaFaltas();
        List<Aviso> avisos = escolaService.listarAvisos();

        model.addAttribute("professor", professor);
        model.addAttribute("faltas", todasFaltas);
        model.addAttribute("avisos", avisos);
        model.addAttribute("novoAviso", new Aviso());

        return "professor-dashboard";
    }

    @PostMapping("/professor/falta/abonar")
    public String abonarFalta(@RequestParam int idFalta) {
        escolaService.abonarFaltas(idFalta);
        return "redirect:/professor/dashboard";
    }

    @PostMapping("/professor/aviso/salvar")
    public String salvarAviso(@ModelAttribute("novoAviso") Aviso avisoRecebido, Authentication auth) {
        escolaService.salvarAviso(avisoRecebido, auth.getName());
        return "redirect:/professor/dashboard";
    }

    @PostMapping("/professor/aviso/excluir")
    public String excluirAviso(@RequestParam int idAviso) {
        escolaService.excluirAviso(idAviso);
        return "redirect:/professor/dashboard";
    }

    @GetMapping("/cadastro/aluno")
    public String formCadastroAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "cadastro-aluno";
    }

    @PostMapping("/cadastro/aluno")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        cadastroService.cadastrarAluno(aluno);
        return "redirect:/login?sucesso";
    }

    @GetMapping("/cadastro/professor")
    public String formCadastroProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "cadastro-professor";
    }

    @PostMapping("/cadastro/professor")
    public String salvarProfessor(@ModelAttribute Professor professor) {
        cadastroService.cadastrarProfessor(professor);
        return "redirect:/login?sucesso";
    }
}