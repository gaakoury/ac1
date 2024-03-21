package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {

    @Autowired
        private EntityManager entityManager;

        @Transactional
    public void inserir(Produto produto){
        entityManager.merge(produto);
    }

    public Produto editar(Produto produto){
        String jpql = "UPDATE p FROM Produto p SET p.prod_nome = :nome, p.prod_qtd = :quantidade";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        return query.getResultList().get(0);
    }

    public void excluir(int id){
        String jpql = "DELETE p FROM Produto p WHERE p.id = :id";
        entityManager.createQuery(jpql, Produto.class);
        }

    public List<Produto> obterPorid(){
        return entityManager.createQuery("SELECT p FROM Produto p where p.id like :id ", 
        Produto.class).getResultList();
    }

    public List<Produto> obterTodos(){
        return entityManager.createQuery("SELECT p FROM Produto p", 
        Produto.class).getResultList();}

}

