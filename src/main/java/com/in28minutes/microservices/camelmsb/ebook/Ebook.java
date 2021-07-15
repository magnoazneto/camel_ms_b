package com.in28minutes.microservices.camelmsb.ebook;

import com.in28minutes.microservices.camelmsb.ebook.input.Livro;

import javax.persistence.*;

@Entity
@Table(name = "ebook")
public class Ebook {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String formato;
    private Integer quantidade;
    @Embedded
    private Livro livro;

    /**
     * only for JPA
     */
    @Deprecated
    public Ebook() {
    }

    public Ebook(String formato, Integer quantidade, Livro livro) {
        this.formato = formato;
        this.quantidade = quantidade;
        this.livro = livro;
    }

    public Long getId() {
        return id;
    }

    public String getFormato() {
        return formato;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Livro getLivro() {
        return livro;
    }
}
