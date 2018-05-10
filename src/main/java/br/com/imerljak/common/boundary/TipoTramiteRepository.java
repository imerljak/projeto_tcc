package br.com.imerljak.common.boundary;

import br.com.imerljak.common.entity.TipoTramite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoTramiteRepository extends JpaRepository<TipoTramite, Long> {
}
