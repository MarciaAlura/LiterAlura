package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private Long data_nascimento;
    private Long data_falecimento;


    public static Artista fromPersonData(DadosArtista dadosArtista) {
        Artista autor = new Artista();
        autor.nome = dadosArtista.autores();
        autor.data_falecimento = dadosArtista.falecimento();
        autor.data_nascimento = dadosArtista.nascimento();
        return autor;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Long data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Long getData_falecimento() {
        return data_falecimento;
    }

    public void setData_falecimento(Long data_falecimento) {
        this.data_falecimento = data_falecimento;
    }
}
