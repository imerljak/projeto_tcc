package br.com.imerljak.publico.controller;


import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.concessionarias.service.ConcessionariaRepository;
import br.com.imerljak.ouvidorias.model.AnexoOuvidoria;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.service.OuvidoriaRepository;
import br.com.imerljak.processos.model.Processo;
import br.com.imerljak.processos.service.ProcessoRepository;
import br.com.imerljak.utils.FileUploader;
import br.com.imerljak.utils.UploadPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/cidadao")
@Controller
public class OuvidoriasPublicController {

    private final OuvidoriaRepository ouvidoriaRepository;
    private final ProcessoRepository processoRepository;
    private final ConcessionariaRepository concessionariaRepository;

    public OuvidoriasPublicController(OuvidoriaRepository ouvidoriaRepository, ProcessoRepository processoRepository, ConcessionariaRepository concessionariaRepository) {
        this.ouvidoriaRepository = ouvidoriaRepository;
        this.processoRepository = processoRepository;
        this.concessionariaRepository = concessionariaRepository;
    }

    @GetMapping
    public String publicView() {
        return "publico";
    }

    @GetMapping("/concessionarias")
    @ResponseBody
    public List<Concessionaria> concessionarias() {
        return concessionariaRepository.findAll();
    }

    @GetMapping("/ouvidorias")
    @ResponseBody
    public Page<Ouvidoria> ouvidoriasPage(@PageableDefault Pageable pageable) {
        return ouvidoriaRepository.findAll(pageable);
    }

    @PostMapping(value = "/addOuvidoria")
    @ResponseBody
    public ResponseEntity<Ouvidoria> postOuvidoria(Ouvidoria ouvidoria, MultipartFile[] files) {
        System.out.println(ouvidoria.getTipo());

        FileUploader.save(files, UploadPath.OUVIDORIAS);

        for (MultipartFile file : files) {
            ouvidoria.addAnexo(AnexoOuvidoria.from(file, UploadPath.OUVIDORIAS));
        }

        final Concessionaria concessionariaProxy = concessionariaRepository.getOne(ouvidoria.getConcessionaria().getId());
        ouvidoria.setConcessionaria(concessionariaProxy);

        ouvidoriaRepository.save(ouvidoria);

        return ResponseEntity.accepted()
                .body(ouvidoria);
    }

    @GetMapping("/processos")
    @ResponseBody
    public Page<Processo> processosPage(@PageableDefault Pageable pageable) {
        return processoRepository.findAll(pageable);
    }
}
