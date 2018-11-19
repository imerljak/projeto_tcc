package br.com.imerljak.ouvidorias.listener;

import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.utils.BeanUtil;
import br.com.imerljak.shared.TipoProtocolo;
import br.com.imerljak.shared.service.ProtocoloService;

import javax.persistence.PrePersist;

public class OuvidoriaEntityListener {

    @PrePersist
    void prePersist(Ouvidoria ouvidoria) {

        // Magic :~
        final ProtocoloService protocoloService = BeanUtil.getBean(ProtocoloService.class);
        ouvidoria.setProtocolo(protocoloService.next(TipoProtocolo.OUVIDORIA));
    }
}
