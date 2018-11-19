package br.com.imerljak.shared.service;

import br.com.imerljak.shared.TipoProtocolo;
import br.com.imerljak.shared.model.Protocolo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;

@Slf4j
@Service
public class ProtocoloService {

    private final ProtocoloRepository protocoloRepository;

    @Autowired
    public ProtocoloService(ProtocoloRepository protocoloRepository) {this.protocoloRepository = protocoloRepository;}

    public Protocolo next(TipoProtocolo tipoProtocolo) {
        return protocoloRepository
                .findTopByAnoAndTipoOrderBySequenciaDesc(Year.now(), tipoProtocolo)
                .orElse(new Protocolo(tipoProtocolo))
                .next();
    }

    @Transactional
    public <S extends Protocolo> S save(S s) {return protocoloRepository.save(s);}
}
