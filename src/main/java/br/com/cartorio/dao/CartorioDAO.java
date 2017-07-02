package br.com.cartorio.dao;

import br.com.cartorio.model.Cartorio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;

@Repository
@Transactional
public class CartorioDAO{

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Cartorio entidade) {
        entidade.setAdicionadoEm(Calendar.getInstance());
        manager.persist(entidade);
    }

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
