package br.com.imerljak.processos.boundary;

import br.com.imerljak.common.boundary.TipoRepository;
import br.com.imerljak.processos.entity.TipoProcesso;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TipoProcessoRepository extends TipoRepository<TipoProcesso, Long> {
}
