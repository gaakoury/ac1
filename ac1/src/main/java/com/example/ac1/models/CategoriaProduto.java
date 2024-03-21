package com.example.ac1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class CategoriaProduto {
    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    @Column(nullable = false)
    private String cat_nome;
    @Column(nullable = false)
    private String cat_descricao;
    
    @OneToMany(mappedBy = "categoriaProduto")
        private List<Produto> produto;

    public CategoriaProduto(int id_categoria, String cat_nome, String cat_descricao) {
        this.id_categoria = id_categoria;
        this.cat_nome = cat_nome;
        this.cat_descricao = cat_descricao;
    }
    public CategoriaProduto() {
    }
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public String getCat_nome() {
        return cat_nome;
    }
    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }
    public String getCat_descricao() {
        return cat_descricao;
    }
    public void setCat_descricao(String cat_descricao) {
        this.cat_descricao = cat_descricao;
    }
}
