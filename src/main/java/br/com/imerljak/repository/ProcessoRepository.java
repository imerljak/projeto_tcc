package br.com.imerljak.repository;

import br.com.imerljak.domain.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

}
