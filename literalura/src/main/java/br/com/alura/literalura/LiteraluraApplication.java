package br.com.alura.literalura;

import br.com.alura.literalura.principal.Principal;
import br.com.alura.literalura.repository.AutoresRepository;
import br.com.alura.literalura.repository.LivrosRepository;
import br.com.alura.literalura.service.BookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private AutoresRepository repositorio;
	@Autowired
	private LivrosRepository repositorioLivro;
	@Autowired
	private BookApiService bookApiService;
	@Autowired
	private LivrosRepository livroRepository;
	@Autowired
	private AutoresRepository autorRepository;

	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		Principal principal = new Principal(bookApiService, livroRepository, autorRepository);
		principal.exibeMenu();

	}

}
