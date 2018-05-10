package br.com.imerljak.processos.boundary;

import br.com.imerljak.processos.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {


}
