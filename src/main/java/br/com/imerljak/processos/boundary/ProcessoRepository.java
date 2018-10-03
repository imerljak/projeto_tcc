package br.com.imerljak.processos.boundary;

import br.com.imerljak.processos.entity.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

    Integer countProcessosByDataCriacaoBetween(LocalDateTime start, LocalDateTime end);

}
