package br.com.imerljak.repository;

import br.com.imerljak.domain.TipoTramite;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("tipoTramite")
public class TipoTramiteRepository extends AbstractRepository<TipoTramite, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTramiteRepository() {
        super(TipoTramite.class);
    }

}
