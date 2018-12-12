package br.com.imerljak.shared.service;

import br.com.imerljak.shared.model.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoRepository extends JpaRepository<Anexo, Long> {
}
