package br.com.herois.heroisapi.repositorio;

import br.com.herois.heroisapi.documento.Herois;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroisRepositorio extends CrudRepository<Herois, String> {
}
