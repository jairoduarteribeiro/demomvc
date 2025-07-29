package com.example.demomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demomvc.dao.TarefaDao;
import com.example.demomvc.entity.Tarefa;

@Service
@Transactional(readOnly = false)
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaDao dao;

    @Override
    public void salvar(Tarefa tarefa) {
        // TODO Auto-generated method stub
        dao.save(tarefa);

    }

    @Override
    public void editar(Tarefa tarefa) {
        // TODO Auto-generated method stub
        dao.update(tarefa);

    }

    @Override
    public void excluir(Long id) {
        // TODO Auto-generated method stub
        dao.delete(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Tarefa buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarefa> buscaTodos() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }

}
