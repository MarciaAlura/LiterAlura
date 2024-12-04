package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public record   DadosArtista(
        @JsonAlias("birth_year")Long nascimento,
        @JsonAlias("death_year")Long falecimento,
        @JsonAlias("name") String autores) {

}
