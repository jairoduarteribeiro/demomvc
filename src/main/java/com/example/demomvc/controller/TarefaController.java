package com.example.demomvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demomvc.entity.Tarefa;
import com.example.demomvc.service.TarefaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/cadastro")
    public String cadastro(ModelMap model) {
        model.addAttribute("tarefa", new Tarefa());
        return "tarefa/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Tarefa tarefa) {
        tarefaService.salvar(tarefa);
        return "redirect:/tarefas/lista";
    }

    @GetMapping("/lista")
    public String lista(ModelMap model) {
        model.addAttribute("tarefas", tarefaService.buscaTodos());
        return "tarefa/lista";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable Long id, ModelMap model) {
        model.addAttribute("tarefa", tarefaService.buscarPorId(id));
        return "/tarefa/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Tarefa tarefa) {
        tarefaService.editar(tarefa);
        return "redirect:/tarefas/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, ModelMap model) {
        tarefaService.excluir(id);
        return lista(model);
    }

}
