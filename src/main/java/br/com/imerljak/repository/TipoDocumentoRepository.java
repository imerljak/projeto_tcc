package br.com.imerljak.repository;

import br.com.imerljak.domain.TipoDocumento;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("tipoDocumento")
public class TipoDocumentoRepository extends AbstractRepository<TipoDocumento, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDocumentoRepository() {
        super(TipoDocumento.class);
    }

}
