package br.com.imerljak.processos.service;

import br.com.imerljak.processos.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
