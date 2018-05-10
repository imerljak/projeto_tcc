package br.com.imerljak.processos.boundary;

import br.com.imerljak.processos.entity.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

}
