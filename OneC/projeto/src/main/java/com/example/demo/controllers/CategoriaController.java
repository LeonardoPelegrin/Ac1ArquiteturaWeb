package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.CategoriaProduto;
import com.example.demo.repositories.CategoriaProdutoRepository;

@RestController
@RequestMapping("api/categoria-produto")
public class CategoriaController{
private CategoriaProdutoRepository categoriaProdutoRepository;

public CategoriaController(
    CategoriaProdutoRepository categoriaProdutoRepository){
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    @GetMapping()
    public List<CategoriaProduto> obterTodos(){
        return categoriaProdutoRepository.obterTodos();
    }
    @PostMapping()
    public void inserir(@RequestBody CategoriaProduto categoria){
        categoriaProdutoRepository.inserir(categoria);
    }

}