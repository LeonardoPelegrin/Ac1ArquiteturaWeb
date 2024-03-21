package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.CategoriaProduto;
import com.example.demo.models.Produto;
import com.example.demo.repositories.CategoriaProdutoRepository;
import com.example.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaProdutoRepository categoriaProdutoRepository) {
				return args -> {
					categoriaProdutoRepository.inserir(new CategoriaProduto(0, "Perifericos"));
					categoriaProdutoRepository.inserir(new CategoriaProduto(0, "Limpeza"));

					System.out.println("*** Listar todas as categorias ***");
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.obterTodos();
			listaCategorias.forEach(System.out::println);

			produtoRepository.inserir(new Produto(0l, "Mouse", 1999));
			produtoRepository.inserir(new Produto(0l, "Ipe", 1999));

			System.out.println("Exemplo Listar todos os Produtos");
			List<Produto> listaprodutos = produtoRepository.obterTodos();
			listaprodutos.forEach(System.out::println);
			
			Produto prod1 = listaprodutos.get(0);
			Produto prod2 = listaprodutos.get(1);

			prod1.setCategoriaProduto(listaCategorias.get(0));
			prod2.setCategoriaProduto(listaCategorias.get(1));

			produtoRepository.inserir(prod1);
			produtoRepository.inserir(prod2);
			

			//System.out.println("Exemplo Listar por id");
			//listaprodutos = ProdutoRepository.obterPorId(1);
			//listaprodutos.forEach(System.out::println);

				};
			}
				public static void main(String[] args) {
					SpringApplication.run(DemoApplication.class, args);
				};
				


}

