package com.example.demomvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demomvc.entity.Tarefa;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    private List<Tarefa> tarefas = new ArrayList<>();

    @GetMapping("/cadastro")
    public String cadastro() {
        return "tarefa/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Tarefa tarefa) {
        Long id = tarefas.stream()
                .mapToLong(Tarefa::getId)
                .max()
                .orElse(0) + 1;
        tarefa.setId(id);
        tarefas.add(tarefa);
        return "redirect:/tarefas/lista";
    }

    @GetMapping("/lista")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("tarefa/lista");
        mv.addObject("tarefas", tarefas);
        return mv;
    }

}
