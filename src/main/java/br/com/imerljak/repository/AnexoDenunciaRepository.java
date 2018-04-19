package br.com.imerljak.repository;

import br.com.imerljak.domain.AnexoDenuncia;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("anexoDenuncia")
public class AnexoDenunciaRepository extends AbstractRepository<AnexoDenuncia, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnexoDenunciaRepository() {
        super(AnexoDenuncia.class);
    }

}
