package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        Integer id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<PersonData> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Integer downloads
)
 {


}
