package br.com.imerljak.ouvidorias.controller;

import br.com.imerljak.concessionarias.service.ConcessionariaRepository;
import br.com.imerljak.ouvidorias.model.AnexoOuvidoria;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.service.OuvidoriaService;
import br.com.imerljak.ouvidorias.value.SituacaoOuvidoria;
import br.com.imerljak.ouvidorias.value.TipoOuvidoria;
import br.com.imerljak.utils.FileUploader;
import br.com.imerljak.utils.Redirect;
import br.com.imerljak.utils.UploadPath;
import br.com.imerljak.visao.AlertMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Slf4j
@Controller
@RequestMapping("/ouvidorias")
public class OuvidoriaController {

    private final OuvidoriaService service;
    private final ConcessionariaRepository concessionariaRepository;

    @Autowired
    public OuvidoriaController(OuvidoriaService service, ConcessionariaRepository concessionariaRepository) {
        this.service = service;
        this.concessionariaRepository = concessionariaRepository;
    }

    @ModelAttribute
    private void modelAttributes(Model model) {
        model.addAttribute("concessionarias", concessionariaRepository.findAll());
        model.addAttribute("tiposOuvidoria", TipoOuvidoria.VALUES);
        model.addAttribute("situacoesOuvidoria", SituacaoOuvidoria.values);
    }


    @GetMapping
    public ModelAndView index(@ModelAttribute Ouvidoria ouvidoria, @PageableDefault Pageable pageable) {

        final PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("id").descending());

        ModelAndView modelAndView = new ModelAndView("ouvidorias/list");

        modelAndView.addObject("ouvidorias", service.search(ouvidoria, pageRequest));

        modelAndView.addObject("denunciasNoMes", service.countBy(TipoOuvidoria.DENUNCIA));
        modelAndView.addObject("reclamacoesNoMes", service.countBy(TipoOuvidoria.RECLAMACAO));
        modelAndView.addObject("sugestoesNoMes", service.countBy(TipoOuvidoria.SUGESTAO));
        modelAndView.addObject("elogiosNoMes", service.countBy(TipoOuvidoria.ELOGIO));

        modelAndView.addObject("example", ouvidoria);
        return modelAndView;
    }

    @DeleteMapping("/remover")
    public String destroy(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        service.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Ouvidoria removida com sucesso!");
        return "redirect:/ouvidorias";
    }

    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("ouvidorias/view");
        modelAndView.addObject("ouvidoria", service.findById(id));
        return modelAndView;
    }

    @GetMapping("/adicionar")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("ouvidorias/form");
        modelAndView.addObject("ouvidoria", new Ouvidoria());
        return modelAndView;
    }

    @PostMapping(value = "/adicionar")
    private String store(@Validated Ouvidoria ouvidoria, MultipartFile[] files, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "/ouvidorias/form";
        }

        FileUploader.save(files, UploadPath.OUVIDORIAS);
        for (MultipartFile file : files) {
            ouvidoria.addAnexo(AnexoOuvidoria.from(file, UploadPath.OUVIDORIAS));
        }

        service.save(ouvidoria);

        redirectAttributes.addFlashAttribute("success", successSaveMessage(ouvidoria));
        return Redirect.to("/ouvidorias");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView updateForm(@PathVariable Long id, ModelAndView modelAndView) {
        final Ouvidoria ouvidoria = service.findById(id)
                .orElseThrow(EntityNotFoundException::new);


        modelAndView.setViewName("ouvidorias/form");
        modelAndView.addObject("ouvidoria", ouvidoria);

        return modelAndView;
    }

    @PutMapping("/editar/{id}")
    public String save(@PathVariable Long id, Ouvidoria ouvidoria, MultipartFile[] files, RedirectAttributes redirectAttributes) {
        final Ouvidoria old = service.getOne(id);
        old.setSituacao(ouvidoria.getSituacao());

        FileUploader.save(files, UploadPath.OUVIDORIAS);
        for (MultipartFile file : files) {
            old.addAnexo(AnexoOuvidoria.from(file, UploadPath.OUVIDORIAS));
        }

        service.save(old);

        redirectAttributes.addFlashAttribute("message", succesUpdateMessage(old));
        return Redirect.to("/ouvidorias");
    }

    private AlertMessage succesUpdateMessage(Ouvidoria ouvidoria) {

        return AlertMessage.with()
                .message(
                        ouvidoria.getTipo().getDescricao() +
                                " " +
                                ouvidoria.getProtocolo().asString() +
                                " atualizada com sucesso!")
                .build();
    }

    private AlertMessage successSaveMessage(Ouvidoria ouvidoria) {
        return AlertMessage.with()
                .message(ouvidoria.getTipo().getDescricao() +
                                 " " +
                                 ouvidoria.getProtocolo().asString() +
                                 " registrada com sucesso!")
                .build();
    }

}
