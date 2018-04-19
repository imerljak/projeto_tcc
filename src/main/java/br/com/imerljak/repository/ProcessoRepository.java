package br.com.imerljak.repository;

import br.com.imerljak.domain.Processo;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("processo")
public class ProcessoRepository extends AbstractRepository<Processo, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcessoRepository() {
        super(Processo.class);
    }

}
