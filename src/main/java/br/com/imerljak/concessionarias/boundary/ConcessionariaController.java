package br.com.imerljak.concessionarias.boundary;

import br.com.imerljak.concessionarias.control.CnpjUtil;
import br.com.imerljak.concessionarias.entity.Concessionaria;
import br.com.imerljak.concessionarias.entity.Representante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("/concessionarias")
public class ConcessionariaController {

    private ConcessionariaRepository repository;

    @Autowired
    public ConcessionariaController(ConcessionariaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ModelAndView listConcessionarias(@PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("concessionarias/list");
        modelAndView.addObject("concessionarias", repository.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/adicionar")
    public ModelAndView createConcessionaria() {
        ModelAndView modelAndView = new ModelAndView("concessionarias/create");

        Concessionaria concessionaria = new Concessionaria();
        concessionaria.getRepresentantes().add(new Representante());
        modelAndView.addObject("concessionaria", concessionaria);
        return modelAndView;
    }

    @PostMapping("/adicionar")
    public String createConcessionaria(@Validated Concessionaria concessionaria, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        repository.findByCnpj(CnpjUtil.unformat(concessionaria.getCnpj()))
                .ifPresent(c -> bindingResult.rejectValue("cnpj", "{Duplicate.concessionaria.cnpj}"));

        if (bindingResult.hasErrors()) {
            return "concessionarias/create";
        }

        repository.save(concessionaria);
        redirectAttributes.addFlashAttribute("mensagem", "Concessionaria gravada com sucesso!");
        return "redirect:/concessionarias";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editConcessionaria(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("concessionarias/update");
        modelAndView.addObject("concessionaria",
                               repository.findById(id).orElseThrow(EntityNotFoundException::new));
        return modelAndView;
    }

    @PutMapping("/editar")
    public String updateConcessionaria(@Validated Concessionaria concessionaria, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "concessionarias/update";
        }

        repository.save(concessionaria);
        redirectAttributes.addFlashAttribute("mensagem", "Concessionária alterada com sucesso!");
        return "redirect:/concessionarias";
    }

    @DeleteMapping("/remover")
    public String removeConcessionaria(Long id, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Concessionária removida com sucesso!");
        return "redirect:/concessionarias";
    }

    @GetMapping("/detalhes/{id}")
    public ModelAndView viewConcessionaria(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("concessionarias/view");
        modelAndView.addObject("concessionaria",
                               repository.findById(id).orElseThrow(EntityNotFoundException::new));
        return modelAndView;
    }

}
