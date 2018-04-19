package br.com.imerljak.repository;

import br.com.imerljak.domain.TramiteProcesso;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("tramiteProcesso")
public class TramiteProcessoRepository extends AbstractRepository<TramiteProcesso, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TramiteProcessoRepository() {
        super(TramiteProcesso.class);
    }

}
