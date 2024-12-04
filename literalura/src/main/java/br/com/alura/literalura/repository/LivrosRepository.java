package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByIdioma(String idioma);

    Integer countByIdioma(String idioma);

    List<Livro> findTop10ByOrderByDownloadsDesc();

}
