package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.CategoriaProduto;
import com.example.ac1.models.Produto;
import com.example.ac1.repositories.CategoriaProdutoRepository;
import com.example.ac1.repositories.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
		@Autowired CategoriaProdutoRepository categoriaProdutoRepository){
		return args -> {

			categoriaProdutoRepository.inserir(new CategoriaProduto(0, "Ferramenta", "Metal"));
			categoriaProdutoRepository.inserir(new CategoriaProduto(0, "Limpeza", "Doméstica"));

			System.out.println("*** Listar Todas as Catergorias ***");
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.obterTodos();
			listaCategorias.forEach(System.out::println);


			System.out.println("*** Listar Todas os Produtos ***");
			List<Produto> listaProdutos = produtoRepository.obterTodos();
			listaProdutos.forEach(System.out::println);


			produtoRepository.inserir(new Produto(01, "Chave de Fenda", 2));
			produtoRepository.inserir(new Produto(01, "Alvejante", 12));

		

		};
	}




















	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
