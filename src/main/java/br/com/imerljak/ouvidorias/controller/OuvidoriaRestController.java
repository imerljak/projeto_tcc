package br.com.imerljak.ouvidorias.controller;

import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.service.OuvidoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/ouvidorias")
@RestController
public class OuvidoriaRestController {

    private final OuvidoriaRepository repository;

    public OuvidoriaRestController(OuvidoriaRepository repository) {this.repository = repository;}

    @GetMapping("/byConcessionaria/{id}")
    public Page<Ouvidoria> findByConcessionaria(@PathVariable Concessionaria id, @PageableDefault Pageable pageable) {
        return repository.findByConcessionaria(id, pageable);
    }

}
