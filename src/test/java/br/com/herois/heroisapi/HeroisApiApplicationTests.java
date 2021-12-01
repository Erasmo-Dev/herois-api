package br.com.herois.heroisapi;

import br.com.herois.heroisapi.repositorio.HeroisRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static br.com.herois.heroisapi.constantes.HeroisConstante.HEROIS_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroisApiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroisRepositorio heroisRepositorio;


	@Test
	public void pegarUmHeroiPorId(){

		webTestClient.get().uri(HEROIS_ENDPOINT_LOCAL.concat("/{id}"),"10")
				.exchange()
				.expectStatus().isOk()
				.expectBody();


	}

	@Test
	public void pegarUmHeroiNaoEncontrado(){

		webTestClient.get().uri(HEROIS_ENDPOINT_LOCAL.concat("/{id}"),"10")
				.exchange()
				.expectStatus().isNotFound();

	}


	@Test
	public void deletarHeroi(){

		webTestClient.delete().uri(HEROIS_ENDPOINT_LOCAL.concat("/{id}"),"1")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}

}
