package com.cencal.gestao_alunos.controller;

import com.cencal.gestao_alunos.model.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Controller

@RequestMapping("/registo")
public class AlunoController {

    private final List<Aluno> alunos = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "redirect:/registo";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunos);
        model.addAttribute("novoAluno", new Aluno());
        return "registo"; // nome do arquivo HTML (registo.html)
    }

    @PostMapping
    public String adicionar(@ModelAttribute Aluno novoAluno, Model model) {
        alunos.add(novoAluno);
        model.addAttribute("showToast", true);
        model.addAttribute("toastMessage", "Aluno adicionado com sucesso!");
        model.addAttribute("toastType", "success");
        return "redirect:/registo";
    }

    @PostMapping("/remover")
    public String remover(@RequestParam int indice,Model model) {
        if (indice >= 0 && indice < alunos.size()) {
            alunos.remove(indice);
            model.addAttribute("showToast", true);
            model.addAttribute("toastMessage", "Aluno removido com sucesso!");
            model.addAttribute("toastType", "error");
        }
        return "redirect:/registo";
    }

    @GetMapping("/ordenar")
    public String ordenarAlunos(@RequestParam(required = false) String sort, Model model){
        if(sort != null){
            switch (sort){
                case "nome":
                    alunos.sort(Comparator.comparing(Aluno::getNome));
                    break;
                case "idade":
                    alunos.sort(Comparator.comparing(Aluno::getIdade));
                    break;
                case "matricula":
                    alunos.sort(Comparator.comparing(Aluno::getMatricula));
                    break;
            }
        }
        model.addAttribute("alunos",alunos);
        model.addAttribute("novoAluno", new Aluno());
        return "registo";

    }

}