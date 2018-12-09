package br.com.imerljak.publico.controller;


import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.service.OuvidoriaRepository;
import br.com.imerljak.processos.model.Processo;
import br.com.imerljak.processos.service.ProcessoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/cidadao")
@Controller
public class OuvidoriasPublicController {

    private final OuvidoriaRepository ouvidoriaRepository;
    private final ProcessoRepository processoRepository;

    public OuvidoriasPublicController(OuvidoriaRepository ouvidoriaRepository, ProcessoRepository processoRepository) {
        this.ouvidoriaRepository = ouvidoriaRepository;
        this.processoRepository = processoRepository;
    }

    @GetMapping
    public String publicView() {
        return "publico";
    }

    @GetMapping("/ouvidorias")
    @ResponseBody
    public Page<Ouvidoria> ouvidoriasPage(@PageableDefault Pageable pageable) {
        return ouvidoriaRepository.findAll(pageable);
    }

    @GetMapping("/processos")
    @ResponseBody
    public Page<Processo> processosPage(@PageableDefault Pageable pageable) {
        return processoRepository.findAll(pageable);
    }
}
