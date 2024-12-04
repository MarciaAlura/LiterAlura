package br.com.alura.literalura.principal;


import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.AutoresRepository;
import br.com.alura.literalura.repository.LivrosRepository;
import br.com.alura.literalura.service.BookApiService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Principal {

    private final LivrosRepository livroRepository;
    private final AutoresRepository autorRepository;
    private final BookApiService bookApiService;
    private final Scanner leitura = new Scanner(System.in);
    private final List<String> possibleQueryLanguages;

    private final String ENDERECO = "https://gutendex.com/books";
    private String complemento_titulo_autores = "?search=";
    private String complemento_idioma = "?languages=";

      public Principal(BookApiService bookApiService,
                     LivrosRepository livroRepository,
                     AutoresRepository autorRepository
                     ) {

        this.bookApiService = bookApiService;
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;

        possibleQueryLanguages = new ArrayList<>();
        possibleQueryLanguages.add("pt");
        possibleQueryLanguages.add("en");
        possibleQueryLanguages.add("es");
        possibleQueryLanguages.add("fr");
    }

    public void exibeMenu(){

        var opcao = -1;

        while (opcao !=0) {

            var menu = """
                    ""
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Lista autores
                    4 - Listar autores em determinado ano
                    5 - Listar livros em determinado idioma
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();


            switch (opcao) {

                case 1:
                    buscarLivropeloTitulo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("\n[!] -Opção inválida!!!");
            }
        }

    }

    private void buscarLivropeloTitulo() {

        System.out.println("\nBUSCA POR TÍTULO ********************************************");
        System.out.print("Digite o título do livro: ");
        var titulo = leitura.nextLine();

        System.out.println("\nPesquisando...\n");
        var bookData = bookApiService.search(titulo).stream().findFirst();

        if (bookData.isEmpty()) {
            System.out.println("[i] - Nenhum livro encontrado\n");
        } else {
            var livro = Livro.fromBookData(bookData.get());
            autorRepository.save(livro.getAutor());
            livroRepository.save(livro);
            System.out.println(livro + "\n");
        }
    }

}
