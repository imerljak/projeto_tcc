package br.com.imerljak.processos.controller;

import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.processos.model.Processo;
import br.com.imerljak.processos.service.ProcessoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/processos")
@RestController
public class ProcessoRestController {

    private final ProcessoRepository repository;

    public ProcessoRestController(ProcessoRepository repository) {this.repository = repository;}

    @GetMapping("/byConcessionaria/{id}")
    public Page<Processo> findByConcessionaria(@PathVariable Concessionaria id, @PageableDefault Pageable pageable) {
        return repository.findByConcessionaria(id, pageable);
    }
}
