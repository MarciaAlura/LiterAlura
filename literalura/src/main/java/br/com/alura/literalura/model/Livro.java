package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            private String idioma;

            private String titulo;

            @ManyToOne
            private Artista artista;

            public Livro(){}

            public Livro(DadosLivro dadosLivro){
                this.titulo = dadosLivro.titulo();

            }

    public static Livro fromBookData(DadosLivro dadosLivro) {
        var livro = new Livro();
        livro.id = dadosLivro.id();
        livro.titulo = dadosLivro.titulo();

        if (!dadosLivro.idiomas().isEmpty()) {
            livro.idioma = dadosLivro.idiomas().get(0);
        }

        if (!dadosLivro.autores().isEmpty()) {
            livro.artista = Artista.fromPersonData(dadosLivro.autores().get(0));
        }

        return livro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo
                + "\nAutor(a): " + (artista == null ? "-" : artista.toString())
                + "\nIdioma: " + (idioma == null ? "-" : idioma);

    }
}
