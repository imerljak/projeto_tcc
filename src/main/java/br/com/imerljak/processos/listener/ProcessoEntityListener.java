package br.com.imerljak.processos.listener;

import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.utils.BeanUtil;
import br.com.imerljak.shared.TipoProtocolo;
import br.com.imerljak.shared.service.ProtocoloService;

import javax.persistence.PrePersist;

public class ProcessoEntityListener {

    @PrePersist
    void prePersist(Ouvidoria ouvidoria) {

        // Magic :~
        final ProtocoloService protocoloService = BeanUtil.getBean(ProtocoloService.class);
        ouvidoria.setProtocolo(protocoloService.next(TipoProtocolo.PROCESSO));
    }
}
