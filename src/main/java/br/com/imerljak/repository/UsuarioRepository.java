package br.com.imerljak.repository;

import br.com.imerljak.domain.Usuario;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("usuario")
public class UsuarioRepository extends AbstractRepository<Usuario, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRepository() {
        super(Usuario.class);
    }

}
