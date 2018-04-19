package br.com.imerljak.repository;

import br.com.imerljak.domain.Denunciante;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("denunciante")
public class DenuncianteRepository extends AbstractRepository<Denunciante, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DenuncianteRepository() {
        super(Denunciante.class);
    }

}
