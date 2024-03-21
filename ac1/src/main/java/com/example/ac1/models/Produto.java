package com.example.ac1.models;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produto")
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produto;
    @Column(nullable = false)
    private String prod_nome;
    @Column(nullable = false)
    private int prod_qtd;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaProduto categoriaProduto;


    public Produto(int id_produto, String prod_nome, int prod_qtd) {
        this.id_produto = id_produto;
        this.prod_nome = prod_nome;
        this.prod_qtd = prod_qtd;
    }
    public Produto() {
    }
    public int getId_produto() {
        return id_produto;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    public String getProd_nome() {
        return prod_nome;
    }
    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }
    public int getProd_qtd() {
        return prod_qtd;
    }
    public void setProd_qtd(int prod_qtd) {
        this.prod_qtd = prod_qtd;
    }
    
}
