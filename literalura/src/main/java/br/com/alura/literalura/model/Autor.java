package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor")
    private Set<Livro> livros;

    public Autor() {
    }

    public static Autor fromPersonData(PersonData personData) {
        Autor autor = new Autor();
        autor.nome = personData.nome();
        autor.anoFalecimento = personData.anoMorte();
        autor.anoNascimento = personData.anoNascimento();
        return autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        var stringRepresentation = nome;
        if (anoNascimento != null && anoFalecimento != null) {
            stringRepresentation += " (" + anoNascimento + "-" + anoFalecimento + ")";
        } else if (anoNascimento != null) {
            stringRepresentation += " (" + anoNascimento + "-)";
        } else if (anoFalecimento != null) {
            stringRepresentation += " (-" + anoFalecimento + ")";
        }
        return stringRepresentation;
    }

}
