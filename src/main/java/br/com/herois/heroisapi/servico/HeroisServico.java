package br.com.herois.heroisapi.servico;

import br.com.herois.heroisapi.documento.Herois;
import br.com.herois.heroisapi.repositorio.HeroisRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HeroisServico {

    private final HeroisRepositorio heroisRepositorio;

    public Flux<Herois> encontrarTodos(){

        return Flux.fromIterable(this.heroisRepositorio.findAll());
    }

    public  Mono<Herois> encontrarHeroisPeloId(String id){

        return  Mono.justOrEmpty(this.heroisRepositorio.findById(id));
    }


    public Mono<Herois> save(Herois herois){
        return  Mono.justOrEmpty(this.heroisRepositorio.save(herois));
    }


    public Mono<Boolean> deletarHeroiPorId(String id) {
        heroisRepositorio.deleteById(id);
        return Mono.just(true);

    }

}
