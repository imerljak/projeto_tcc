package br.com.imerljak.repository;

import br.com.imerljak.domain.Representante;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("representante")
public class RepresentanteRepository extends AbstractRepository<Representante, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepresentanteRepository() {
        super(Representante.class);
    }

}
