package br.com.imerljak.shared.service;

import br.com.imerljak.shared.TipoProtocolo;
import br.com.imerljak.shared.model.Protocolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.Optional;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long> {
    Optional<Protocolo> findTopByAnoAndTipoOrderBySequenciaDesc(Year ano, TipoProtocolo tipoProtocolo);
}
