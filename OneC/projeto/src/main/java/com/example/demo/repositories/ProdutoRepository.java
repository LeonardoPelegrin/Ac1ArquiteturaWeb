package com.example.demo.repositories;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;


    @Transactional
    public Produto inserir(Produto produto){
        entityManager.merge(produto);
        return produto;
    }

    public List<Produto> obterTodos() {
        return entityManager.createQuery("SELECT c FROM Produto c", Produto.class)
                .getResultList();
    }
    public List<Produto> obterPorId(int Id) {
        String jpql = " select c from Produto c where c.id like :id";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("nome", "%" + Id + "%");
        return query.getResultList();
    }
}
