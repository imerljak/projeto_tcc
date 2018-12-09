package br.com.imerljak.ouvidorias.service;

import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.value.TipoOuvidoria;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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

    public Page<Ouvidoria> search(Ouvidoria ouvidoria, Pageable pageable) {
        return repository.findAll(Example.of(ouvidoria), pageable);
    }

    public Long countBy(TipoOuvidoria tipoOuvidoria) {

        final Ouvidoria ouvidoria = new Ouvidoria();
        ouvidoria.setTipo(tipoOuvidoria);
        ouvidoria.setSituacao(null);

        final Specification<Ouvidoria> specification =
                Specification
                        .<Ouvidoria>where((root, query, builder) ->
                                                  builder.between(root.get("dataCriacao"), startOfMonth(), endOfMonth()))

                        .and((root, query, builder) ->
                                     builder.equal(root.get("tipo"), tipoOuvidoria));

        return repository.count(specification);
    }

    private LocalDateTime endOfMonth() {
        final LocalDateTime date = LocalDateTime.now();

        return date
                .withDayOfMonth(Month.from(date).maxLength())
                .with(LocalTime.MAX);
    }

    private LocalDateTime startOfMonth() {
        return LocalDate.now()
                .atStartOfDay()
                .withDayOfMonth(1);
    }
}


