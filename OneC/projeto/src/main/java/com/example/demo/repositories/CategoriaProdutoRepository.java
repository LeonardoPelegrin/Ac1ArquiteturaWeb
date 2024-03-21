package com.example.demo.repositories;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


import com.example.demo.models.CategoriaProduto;



@Repository
public class CategoriaProdutoRepository{
    @Autowired
    private EntityManager entitymanager;

    @Transactional
    public void inserir(CategoriaProduto categoriaProduto) {
      entitymanager.merge(categoriaProduto);
    }

      public List<CategoriaProduto> obterTodos() {
        return entitymanager.createQuery("SELECT c FROM CategoriaProduto c",
                CategoriaProduto.class).getResultList();
    }
}
