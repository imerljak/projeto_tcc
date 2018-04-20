package br.com.imerljak.repository;

import br.com.imerljak.domain.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
}
