package br.com.cartorio.dao;

import java.util.List;

public interface DAO<T> {
    void salvar(T entidade);

    void atualizar(T entidade);

    void deletar(Long id);

    List<T> encontrarTodos();

    T encontrarPorId(Long id);
}
