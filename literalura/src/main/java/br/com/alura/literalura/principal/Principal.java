package br.com.alura.literalura.principal;


import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.AutoresRepository;
import br.com.alura.literalura.repository.LivrosRepository;
import br.com.alura.literalura.service.ConsumoAPI;
import br.com.alura.literalura.service.ConverteDados;
import br.com.alura.literalura.service.LivroAPIService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static com.azure.ai.openai.models.OnYourDataAuthenticationType.API_KEY;


public class Principal {


    private final AutoresRepository repositorio;
    private final LivrosRepository repositorioLivro;
    private Scanner leitura = new Scanner(System.in);

    private final String ENDERECO = "https://gutendex.com/books";
    private String complemento_titulo_autores = "?search=";
    private String complemento_idioma = "?languages=";

    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    public Principal(AutoresRepository repositorio, LivrosRepository repositorioLivro) {
        this.repositorio = repositorio;
        this.repositorioLivro = repositorioLivro;
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
                    System.out.println("Opção inválida");
            }
        }

    }

    private void buscarLivropeloTitulo() {

        System.out.println("\n Escolha o titulo do livro: ");
        var nomeLivro = leitura.nextLine();

        var dadosLivro = LivroAPIService
                .procuraLivro(nomeLivro)
                .stream()
                .findFirst();

        System.out.println(dadosLivro);

        if(dadosLivro.isEmpty()){
            System.out.println("Nenhum livro encontrado");
        } else{
            var livro = Livro.fromBookData(dadosLivro.get());
            repositorio.save(livro.getArtista());
            repositorioLivro.save(livro);
            System.out.println(livro + "\n");
        }

    }

}
