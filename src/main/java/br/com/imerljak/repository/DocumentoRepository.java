package br.com.imerljak.repository;

import br.com.imerljak.domain.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
