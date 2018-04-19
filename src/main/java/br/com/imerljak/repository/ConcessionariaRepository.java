package br.com.imerljak.repository;

import br.com.imerljak.domain.Concessionaria;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("concessionaria")
public class ConcessionariaRepository extends AbstractRepository<Concessionaria, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcessionariaRepository() {
        super(Concessionaria.class);
    }

}
