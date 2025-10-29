package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.Aluno;
import org.example.repository.AlunoRepository;
import org.example.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;
    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @GetMapping
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoService.buscarTodas());
        return "alunos";
    }

    @GetMapping("/add")
    public String formAluno(Aluno aluno) {
        return "alunoAdd";
    }

    @GetMapping("/edit/{id}")
    public String formAluno(@PathVariable("id") Long id, Model model) {
        Aluno aluno  = alunoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Aluno inválido:" + id));

        model.addAttribute("aluno", aluno);
        return "alunoAdd";
    }

    @PostMapping("/save")
    public String salvarAluno(@Valid Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
            return  "alunoAdd";
        }

        alunoService.salvar(aluno);

        return "redirect:/alunos";
    }

    @GetMapping("/delete/{id}")
    public String deletarAluno(@PathVariable("id") Long id) {
        alunoService.excluir(id);
        return "redirect:/alunos";
    }
}
