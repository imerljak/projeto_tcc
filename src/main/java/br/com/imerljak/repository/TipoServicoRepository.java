package br.com.imerljak.repository;

import br.com.imerljak.domain.TipoServico;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("tipoServico")
public class TipoServicoRepository extends AbstractRepository<TipoServico, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoServicoRepository() {
        super(TipoServico.class);
    }

}
