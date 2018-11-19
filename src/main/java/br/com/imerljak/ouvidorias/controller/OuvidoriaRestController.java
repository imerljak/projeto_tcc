package br.com.imerljak.ouvidorias.controller;

import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.service.OuvidoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/ouvidorias", produces = "application/json")
public class OuvidoriaRestController {

    private final OuvidoriaRepository repository;

    @Autowired
    public OuvidoriaRestController(OuvidoriaRepository repository) {this.repository = repository;}

    @GetMapping
    public List<Ouvidoria> list() {
        return repository.findAll();
    }

}
