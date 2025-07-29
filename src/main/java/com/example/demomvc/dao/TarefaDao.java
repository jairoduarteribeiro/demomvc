package com.example.demomvc.dao;

import java.util.List;

import com.example.demomvc.entity.Tarefa;

public interface TarefaDao {

    void save(Tarefa tarefa);

    void update(Tarefa tarefa);

    void delete(Long id);

    Tarefa findById(Long id);

    List<Tarefa> findAll();

}
