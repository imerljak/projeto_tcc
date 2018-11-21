package br.com.imerljak.ouvidorias.service;

import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.value.TipoOuvidoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface OuvidoriaRepository extends JpaRepository<Ouvidoria, Long> {

    Integer countByDataCriacaoAfterAndTipo(LocalDateTime dateTime, TipoOuvidoria tipo);

    Integer countByDataCriacaoBetweenAndTipo(LocalDateTime start, LocalDateTime end, TipoOuvidoria tipo);

}
