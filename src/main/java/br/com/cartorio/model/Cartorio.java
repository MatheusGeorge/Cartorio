package br.com.cartorio.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Cartorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar adicionadoEm;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar modificadoEm;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar removidoEm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getAdicionadoEm() {
        return adicionadoEm;
    }

    public void setAdicionadoEm(Calendar adicionadoEm) {
        this.adicionadoEm = adicionadoEm;
    }

    public Calendar getModificadoEm() {
        return modificadoEm;
    }

    public void setModificadoEm(Calendar modificadoEm) {
        this.modificadoEm = modificadoEm;
    }

    public Calendar getRemovidoEm() {
        return removidoEm;
    }

    public void setRemovidoEm(Calendar removidoEm) {
        this.removidoEm = removidoEm;
    }
}
