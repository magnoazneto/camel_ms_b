package com.in28minutes.microservices.camelmsb.ebook.output;

import com.in28minutes.microservices.camelmsb.ebook.Ebook;
import com.in28minutes.microservices.camelmsb.ebook.input.Livro;

import javax.persistence.Embedded;

public class EbookResponse {

    private Long id;
    private String formato;
    private Integer quantidade;
    private Livro livro;

    public EbookResponse(Ebook ebook) {
        this.id = ebook.getId();
        this.formato = ebook.getFormato();;
        this.quantidade = ebook.getQuantidade();
        this.livro = ebook.getLivro();
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
