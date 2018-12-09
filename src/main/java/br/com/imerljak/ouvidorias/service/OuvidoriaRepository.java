package br.com.imerljak.ouvidorias.service;

import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.value.TipoOuvidoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.web.PageableDefault;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public interface OuvidoriaRepository extends JpaRepository<Ouvidoria, Long>, JpaSpecificationExecutor<Ouvidoria> {

    Integer countByDataCriacaoAfterAndTipo(LocalDateTime dateTime, TipoOuvidoria tipo);

    Integer countByDataCriacaoBetweenAndTipo(LocalDateTime start, LocalDateTime end, TipoOuvidoria tipo);

    Page<Ouvidoria> findByConcessionaria(@NotNull Concessionaria id, @PageableDefault Pageable pageable);
}
