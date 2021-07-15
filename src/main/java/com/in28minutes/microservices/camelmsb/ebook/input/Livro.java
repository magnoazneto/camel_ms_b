package com.in28minutes.microservices.camelmsb.ebook.input;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Livro {
    public String codigo;
    public String titulo;
    public String tituloCurto;
    public String nomeAutor;
    public BigDecimal valorEbook;
    public BigDecimal valorImpresso;

    public Livro() {
    }

    public Livro(String codigo,
                 String titulo,
                 String tituloCurto,
                 String nomeAutor,
                 BigDecimal valorEbook,
                 BigDecimal valorImpresso) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.tituloCurto = tituloCurto;
        this.nomeAutor = nomeAutor;
        this.valorEbook = valorEbook;
        this.valorImpresso = valorImpresso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTituloCurto() {
        return tituloCurto;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public BigDecimal getValorEbook() {
        return valorEbook;
    }

    public BigDecimal getValorImpresso() {
        return valorImpresso;
    }

    public void setValorEbook(BigDecimal valorEbook) {
        this.valorEbook = valorEbook;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", tituloCurto='" + tituloCurto + '\'' +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", valorEbook=" + valorEbook +
                ", valorImpresso=" + valorImpresso +
                '}';
    }
}
