package com.example.demomvc.service;

import java.util.List;

import com.example.demomvc.entity.Tarefa;

public interface TarefaService {

    void salvar(Tarefa tarefa);

    void editar(Tarefa tarefa);

    void excluir(Long id);

    Tarefa buscarPorId(Long id);

    List<Tarefa> buscaTodos();

}
