package br.com.imerljak.concessionarias.controller;

import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.concessionarias.model.Responsavel;
import br.com.imerljak.concessionarias.service.ConcessionariaService;
import br.com.imerljak.concessionarias.service.TipoServicoRepository;
import br.com.imerljak.concessionarias.util.CnpjUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/concessionarias")
public class ConcessionariaController {

    private final ConcessionariaService service;
    private final TipoServicoRepository tipoServicoRepository;

    @Autowired
    public ConcessionariaController(ConcessionariaService service, TipoServicoRepository tipoServicoRepository) {
        this.service = service;
        this.tipoServicoRepository = tipoServicoRepository;
    }

    @ModelAttribute
    public void atributos(Model model) {
        model.addAttribute("servicos", tipoServicoRepository.findAll());
    }

    @GetMapping
    public ModelAndView listConcessionarias(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(required = false) String search) {
        ModelAndView modelAndView = new ModelAndView("concessionarias/list");

        modelAndView.addObject("concessionarias", service.search(search, pageable));
        return modelAndView;
    }

    @GetMapping("/adicionar")
    public ModelAndView createConcessionaria() {
        ModelAndView modelAndView = new ModelAndView("concessionarias/create");

        Concessionaria concessionaria = new Concessionaria();
        concessionaria.getResponsaveis().add(new Responsavel());
        modelAndView.addObject("concessionaria", concessionaria);
        return modelAndView;
    }

    @PostMapping("/adicionar")
    public String createConcessionaria(@Validated Concessionaria concessionaria, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        service.findByCnpj(CnpjUtil.unformat(concessionaria.getCnpj()))
                .ifPresent(c -> bindingResult.rejectValue("cnpj", "{Duplicate.concessionaria.cnpj}"));

        if (bindingResult.hasErrors()) {
            return "concessionarias/create";
        }

        service.save(concessionaria);
        redirectAttributes.addFlashAttribute("mensagem", "Concessionaria gravada com sucesso!");
        return "redirect:/concessionarias";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editConcessionaria(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("concessionarias/update");


        Concessionaria concessionaria = service.findById(id).orElseThrow(EntityNotFoundException::new);
        if (concessionaria.getResponsaveis().isEmpty()) {
            concessionaria.getResponsaveis().add(new Responsavel());
        }

        modelAndView.addObject("concessionaria", concessionaria);
        modelAndView.addObject("servicos", tipoServicoRepository.findAll());

        return modelAndView;
    }

    @PutMapping("/editar")
    public String updateConcessionaria(@Validated Concessionaria concessionaria, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult.getAllErrors());
            return "concessionarias/update";
        }

        service.save(concessionaria);
        redirectAttributes.addFlashAttribute("mensagem", "Concessionária alterada com sucesso!");
        return "redirect:/concessionarias";
    }

    @DeleteMapping("/remover")
    public String removeConcessionaria(Long id, RedirectAttributes redirectAttributes) {
        final Concessionaria one = service.getOne(id);
        one.setAtivo(false);
        service.save(one);

        //        service.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Concessionária removida com sucesso!");
        return "redirect:/concessionarias";
    }

    @GetMapping("/{id}")
    public ModelAndView viewConcessionaria(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("concessionarias/view");
        modelAndView.addObject("concessionaria",
                               service.findById(id).orElseThrow(EntityNotFoundException::new));
        return modelAndView;
    }

}
