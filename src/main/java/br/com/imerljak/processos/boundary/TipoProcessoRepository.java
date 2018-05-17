package br.com.imerljak.processos.boundary;

import br.com.imerljak.processos.entity.TipoProcesso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoProcessoRepository extends JpaRepository<TipoProcesso, Long> {

}