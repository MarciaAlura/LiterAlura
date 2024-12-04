package br.com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private Integer downloads;

    @ManyToOne
    private Autor autor;

    public Livro() {
    }

    public static Livro fromBookData(BookData bookData) {
        var livro = new Livro();
        livro.id = Long.valueOf(bookData.id());
        livro.downloads = bookData.downloads();
        livro.titulo = bookData.titulo();

        if (!bookData.idiomas().isEmpty()) {
            livro.idioma = bookData.idiomas().get(0);
        }

        if (!bookData.autores().isEmpty()) {
            livro.autor = Autor.fromPersonData(bookData.autores().get(0));
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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo
                + "\nAutor(a): " + (autor == null ? "-" : autor.toString())
                + "\nIdioma: " + (idioma == null ? "-" : idioma)
                + "\nNúmero de downloads: " + downloads;
    }
}
