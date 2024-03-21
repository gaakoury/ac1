package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.CategoriaProduto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;
    
    @Transactional
    public void inserir(CategoriaProduto categoriaProduto){
        entityManager.merge(categoriaProduto);
    }

    public CategoriaProduto editar(CategoriaProduto categoriaProduto){
        String jpql = "UPDATE c FROM CategoriaProduto c SET c.cat_nome = :nome, c.cat_descricao = :descricao";
        TypedQuery<CategoriaProduto> query = entityManager.createQuery(jpql, CategoriaProduto.class);
        return query.getResultList().get(0);
        }

    public void excluir(int id){
        String jpql = "DELETE c FROM CategoriaProduto c WHERE c.id = :id";       
        
        entityManager.createQuery(jpql, CategoriaProduto.class);
    }

    public List<CategoriaProduto> obterPorid(){
        return entityManager.createQuery("SELECT c FROM CategoriaProduto c where c.id like :id ", 
        CategoriaProduto.class).getResultList();}

    public List<CategoriaProduto> obterTodos(){
        return entityManager.createQuery("SELECT c FROM CategoriaProduto c", 
        CategoriaProduto.class).getResultList();}

 
   
    
}
