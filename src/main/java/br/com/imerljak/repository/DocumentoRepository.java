package br.com.imerljak.repository;

import br.com.imerljak.domain.Documento;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("documento")
public class DocumentoRepository extends AbstractRepository<Documento, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoRepository() {
        super(Documento.class);
    }

}
