package br.com.imerljak.common.boundary;

import br.com.imerljak.common.entity.Tipo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TipoRepository<T extends Tipo, ID> extends CrudRepository<T, ID> {

    Optional<T> findByNome(String nome);

    default void saveIfNotExistsByNome(T t) {
        if (!findByNome(t.getNome()).isPresent()) {
            save(t);
        }
    }

}
