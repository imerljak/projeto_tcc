package br.com.imerljak.repository;

import br.com.imerljak.domain.TramiteDenuncia;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("tramiteDenuncia")
public class TramiteDenunciaRepository extends AbstractRepository<TramiteDenuncia, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TramiteDenunciaRepository() {
        super(TramiteDenuncia.class);
    }

}
