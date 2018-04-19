package br.com.imerljak.repository;

import br.com.imerljak.domain.Denuncia;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("denuncia")
public class DenunciaRepository extends AbstractRepository<Denuncia, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DenunciaRepository() {
        super(Denuncia.class);
    }

}
