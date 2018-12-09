package br.com.imerljak.concessionarias.service;

import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Slf4j
@Service
public class ConcessionariaService {

    private final ConcessionariaRepository repository;


    public ConcessionariaService(ConcessionariaRepository repository) {this.repository = repository;}

    public Optional<Concessionaria> findByCnpj(String cnpj) {return repository.findByCnpj(cnpj);}

    public <S extends Concessionaria> S save(S s) {return repository.save(s);}

    public Optional<Concessionaria> findById(Long aLong) {return repository.findById(aLong);}

    public Concessionaria getOne(Long aLong) {return repository.getOne(aLong);}

    public Object search(String query, Pageable pageable) {

        log.info("query = {}", query);

        if (StringUtils.isEmpty(query)) {
            return repository.findAll(pageable);
        } else {
            return repository.search("%" + query + "%", pageable);
        }
    }

    public Page<Ouvidoria> findAllOuvidoriasDaConcessionaria(Long id, Pageable pageable) {
        return repository.findAllOuvidoriasOf(id, pageable);
    }
}


