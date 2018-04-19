package br.com.imerljak.repository;

import br.com.imerljak.domain.AnexoTramite;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("anexoTramite")
public class AnexoTramiteRepository extends AbstractRepository<AnexoTramite, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnexoTramiteRepository() {
        super(AnexoTramite.class);
    }

}
