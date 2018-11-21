package br.com.imerljak.ouvidorias.service;

import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.value.SituacaoOuvidoria;
import br.com.imerljak.ouvidorias.value.TipoOuvidoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OuvidoriaService {

    private final OuvidoriaRepository repository;
    private final EntityManager entityManager;

    public OuvidoriaService(OuvidoriaRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    public Ouvidoria getOne(Long aLong) {return repository.getOne(aLong);}

    public void deleteById(Long aLong) {repository.deleteById(aLong);}

    public Optional<Ouvidoria> findById(Long aLong) {return repository.findById(aLong);}

    public <S extends Ouvidoria> S save(S s) {return repository.save(s);}

    public Page<Ouvidoria> findAll(Pageable pageable) {return repository.findAll(pageable);}

    public Page<Ouvidoria> search(TipoOuvidoria tipoOuvidoria, SituacaoOuvidoria situacaoOuvidoria, Long idConcessionaria, Pageable pageable) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Ouvidoria> query = builder.createQuery(Ouvidoria.class);
        final Root<Ouvidoria> from = query.from(Ouvidoria.class);

        final CriteriaQuery<Ouvidoria> select = query.select(from);

        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(tipoOuvidoria)) {
            predicates.add(builder.and(builder.equal(from.get("tipo"), tipoOuvidoria)));
        }

        if (Objects.nonNull(situacaoOuvidoria)) {
            predicates.add(builder.and(builder.equal(from.get("situacao"), situacaoOuvidoria)));
        }

        if (Objects.nonNull(idConcessionaria)) {
            predicates.add(builder.and(builder.equal(from.join("concessionaria").get("id"), idConcessionaria)));
        }

        final TypedQuery<Ouvidoria> typedQuery = entityManager.createQuery(select.where(predicates.toArray(new Predicate[0])));
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        return new PageImpl<>(typedQuery.getResultList());

    }
}


