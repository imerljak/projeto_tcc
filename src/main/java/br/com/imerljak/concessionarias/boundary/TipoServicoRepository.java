package br.com.imerljak.concessionarias.boundary;

import br.com.imerljak.concessionarias.entity.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
}
