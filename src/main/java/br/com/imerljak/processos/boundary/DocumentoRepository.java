package br.com.imerljak.processos.boundary;

import br.com.imerljak.processos.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
