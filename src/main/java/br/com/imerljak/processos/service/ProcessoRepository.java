package br.com.imerljak.processos.service;

import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.processos.model.Processo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

    Integer countProcessosByDataCriacaoBetween(LocalDateTime start, LocalDateTime end);

    Page<Processo> findByConcessionaria(@NotNull Concessionaria id, @PageableDefault Pageable pageable);
}
