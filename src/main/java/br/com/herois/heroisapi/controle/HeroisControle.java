package br.com.herois.heroisapi.controle;

import br.com.herois.heroisapi.documento.Herois;
import br.com.herois.heroisapi.repositorio.HeroisRepositorio;
import br.com.herois.heroisapi.servico.HeroisServico;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static br.com.herois.heroisapi.constantes.HeroisConstante.HEROIS_ENDPOINT_LOCAL;

@RestController
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HeroisControle {

    HeroisServico heroisServico;

    HeroisRepositorio heroisRepositorio;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(HeroisControle.class);
    

    @GetMapping(HEROIS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Herois> pegarTodosOsItems() {
        log.info("Requisita a lista de todos os herois");
        return heroisServico.encontrarTodos();

    }


    @GetMapping(HEROIS_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Herois>> encontrarHeroiPorId(@PathVariable String id) {
        log.info("Requisitar heroi com id {}", id);
        return heroisServico.encontrarHeroisPeloId(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROIS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Herois> createHero(@RequestBody Herois Herois) {
        log.info("Um novo heroi foi criado");
        return heroisServico.save(Herois);

    }

    @DeleteMapping(HEROIS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletarHeroiPorId(@PathVariable String id) {
        heroisServico.deletarHeroiPorId(id);
        log.info("Deleting the hero with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }

}
