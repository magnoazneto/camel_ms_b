package com.in28minutes.microservices.camelmsb.ebook.input;

import com.in28minutes.microservices.camelmsb.ebook.Ebook;

public class EbookMQMessage {
    private String formato;
    private Integer quantidade;
    private Livro livro;

    public EbookMQMessage() {
    }

    public EbookMQMessage(String formato, Integer quantidade, Livro livro) {
        this.formato = formato;
        this.quantidade = quantidade;
        this.livro = livro;
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

    public Ebook toModel(){
        return new Ebook(this.formato, this.quantidade, this.livro);
    }

    @Override
    public String toString() {
        return "Ebook{" +
                "formato='" + formato + '\'' +
                ", quantidade=" + quantidade +
                ", livro=" + livro +
                '}';
    }
}
