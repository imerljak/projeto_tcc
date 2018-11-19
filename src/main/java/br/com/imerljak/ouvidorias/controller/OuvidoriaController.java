package br.com.imerljak.ouvidorias.controller;

import br.com.imerljak.concessionarias.service.ConcessionariaRepository;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.ouvidorias.service.OuvidoriaRepository;
import br.com.imerljak.ouvidorias.value.SituacaoOuvidoria;
import br.com.imerljak.ouvidorias.value.TipoOuvidoria;
import br.com.imerljak.visao.AlertMessage;
import br.com.imerljak.utils.Redirect;
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

    private final OuvidoriaRepository repository;
    private final ConcessionariaRepository concessionariaRepository;

    @Autowired
    public OuvidoriaController(OuvidoriaRepository repository, ConcessionariaRepository concessionariaRepository) {
        this.repository = repository;
        System.out.println("repository = " + repository);
        this.concessionariaRepository = concessionariaRepository;
    }

    @ModelAttribute
    private void modelAttributes(Model model) {
        model.addAttribute("concessionarias", concessionariaRepository.findAll());
        model.addAttribute("tiposOuvidoria", TipoOuvidoria.VALUES);
        model.addAttribute("situacoesOuvidoria", SituacaoOuvidoria.values);
    }


    @GetMapping
    public ModelAndView index(@PageableDefault Pageable pageable) {

        final PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("dataCriacao").descending());

        ModelAndView modelAndView = new ModelAndView("ouvidorias/list");
        modelAndView.addObject("ouvidorias", repository.findAll(pageRequest));
        return modelAndView;
    }

    @DeleteMapping("/remover")
    public String destroy(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Ouvidoria removida com sucesso!");
        return "redirect:/ouvidorias";
    }

    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("ouvidorias/view");
        modelAndView.addObject("ouvidoria", repository.findById(id));
        return modelAndView;
    }

    @GetMapping("/adicionar")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("ouvidorias/form");
        modelAndView.addObject("ouvidoria", new Ouvidoria());
        return modelAndView;
    }

    @PostMapping(value = "/adicionar")
    private String store(@Validated Ouvidoria ouvidoria, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "/ouvidorias/form";
        }

        repository.save(ouvidoria);

        redirectAttributes.addFlashAttribute("success", successSaveMessage(ouvidoria));
        return Redirect.to("/ouvidorias");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView updateForm(@PathVariable Long id, ModelAndView modelAndView) {
        final Ouvidoria ouvidoria = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);


        modelAndView.setViewName("ouvidorias/form");
        modelAndView.addObject("ouvidoria", ouvidoria);

        return modelAndView;
    }

    @PutMapping("/editar/{id}")
    public String save(@PathVariable Long id, Ouvidoria ouvidoria, RedirectAttributes redirectAttributes) {
        final Ouvidoria old = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        old.setSituacao(ouvidoria.getSituacao());

        repository.save(old);

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
