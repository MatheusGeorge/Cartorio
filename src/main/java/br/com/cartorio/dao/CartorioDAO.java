package br.com.cartorio.dao;

import br.com.cartorio.model.Cartorio;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

public class CartorioDAO implements DAO <Cartorio>{

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void salvar(Cartorio entidade) {
        manager.persist(entidade);
    }

    @Transactional
    public void atualizar(Cartorio entidade) {
        entidade.setModificadoEm(Calendar.getInstance());
        manager.merge(entidade);
    }


    public void deletar(Long id) {
        TypedQuery<Cartorio> query = manager.createQuery("SELECT c FROM Cartorio c WHERE c.id = :id", Cartorio.class);
        query.setParameter("id", id);
        try {
            Cartorio cartorio = query.getSingleResult();
            cartorio.setRemovidoEm(Calendar.getInstance());
            manager.merge(cartorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cartorio> encontrarTodos() {
        TypedQuery<Cartorio> query = manager.createQuery("SELECT c FROM Cartorio c WHERE c.removidoEm is null", Cartorio.class);
        return query.getResultList();
    }


    public Cartorio encontrarPorId(Long id) {
        Cartorio cartorio = manager.find(Cartorio.class, id);
        return cartorio;
    }
}
