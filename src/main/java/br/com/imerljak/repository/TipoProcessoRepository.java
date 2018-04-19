package br.com.imerljak.repository;

import br.com.imerljak.domain.TipoProcesso;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("tipoProcesso")
public class TipoProcessoRepository extends AbstractRepository<TipoProcesso, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProcessoRepository() {
        super(TipoProcesso.class);
    }

}
