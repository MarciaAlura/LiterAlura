package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoresRepository extends JpaRepository<Artista, Long> {



}
