package br.com.alura.literalura.service;

import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.model.DadosLivroResposta;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.LivrosRepository;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class LivroAPIService {

    private static String baseUrl = "https://gutendex.com/books/";

    public static List<DadosLivro> procuraLivro(String text) {
        var json = ConsumoAPI.obterDados(
                baseUrl + "?search="
                        + URLEncoder.encode(text.trim().toLowerCase(), StandardCharsets.UTF_8)
        );
        var convert = new ConverteDados().obterLista(json, DadosLivro.class);
        return convert;
    }



}
