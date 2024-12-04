package br.com.alura.literalura.service;

import br.com.alura.literalura.model.BookApiResponse;
import br.com.alura.literalura.model.BookData;
import br.com.alura.literalura.model.PersonData;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class BookApiService {

    private final String baseUrl = "https://gutendex.com/books/";

    public List<BookData> search(String text) {
        var json = ApiConsumer.getData(
                baseUrl + "?search="
                        + URLEncoder.encode(text.trim().toLowerCase(), StandardCharsets.UTF_8)
        );
        return new DataConverter().convert(json, BookApiResponse.class).livros();
    }

    public List<PersonData> getAuthorsAliveOnYear(Integer year) {
        var endpoint = baseUrl + "?author_year_start=" + year
                + "&author_year_end=" + year;
        var json = ApiConsumer.getData(endpoint);
        return new DataConverter()
                .convert(json, BookApiResponse.class)
                .livros()
                .stream()
                .flatMap(l -> l.autores().stream())
                .toList();
    }
}
