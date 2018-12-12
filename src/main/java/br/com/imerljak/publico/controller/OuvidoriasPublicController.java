package br.com.imerljak.publico.controller;


import br.com.caelum.stella.validation.Validator;
import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.concessionarias.service.ConcessionariaRepository;
import br.com.imerljak.ouvidorias.model.AnexoOuvidoria;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.service.OuvidoriaRepository;
import br.com.imerljak.ouvidorias.value.TipoDocumentoPessoa;
import br.com.imerljak.processos.model.Processo;
import br.com.imerljak.processos.service.ProcessoRepository;
import br.com.imerljak.shared.model.Protocolo;
import br.com.imerljak.utils.FileUploader;
import br.com.imerljak.utils.UploadPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

        final PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.Direction.DESC, "id");

        return ouvidoriaRepository.findAll(pageRequest);
    }

    @PostMapping(value = "/addOuvidoria")
    @ResponseBody
    public ResponseEntity<?> postOuvidoria(Ouvidoria ouvidoria, MultipartFile[] files) {
        System.out.println(ouvidoria.getTipo());

        @NotNull final TipoDocumentoPessoa tipoDocumento = ouvidoria.getCidadao().getTipoDocumento();
        final Validator<String> validator = tipoDocumento.getValidator();

        if (!isValido(validator, ouvidoria.getCidadao().getDocumento())) {
            System.out.println("INVALIDO!");
            return ResponseEntity.badRequest()
                    .body(Collections.singletonMap("mensagem", tipoDocumento.name() + " inválido."));
        }

        FileUploader.save(files, UploadPath.OUVIDORIAS);

        for (MultipartFile file : files) {
            ouvidoria.addAnexo(AnexoOuvidoria.from(file, UploadPath.OUVIDORIAS));
        }

        final Concessionaria concessionariaProxy = concessionariaRepository.getOne(ouvidoria.getConcessionaria().getId());
        ouvidoria.setConcessionaria(concessionariaProxy);

        ouvidoriaRepository.save(ouvidoria);

        Map<String, Protocolo> protocoloMap = Collections.singletonMap("protocolo", ouvidoria.getProtocolo());

        return ResponseEntity.accepted()
                .body(protocoloMap);
    }

    private boolean isValido(Validator<String> validator, @NotNull String documento) {
        if (!validator.isEligible(documento)) {
            return false;
        }

        return validator.invalidMessagesFor(documento).isEmpty();
    }

    @GetMapping("/processos")
    @ResponseBody
    public Page<Processo> processosPage(@PageableDefault Pageable pageable) {
        return processoRepository.findAll(pageable);
    }
}
