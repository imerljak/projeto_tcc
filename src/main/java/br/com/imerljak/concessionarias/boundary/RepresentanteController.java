package br.com.imerljak.concessionarias.boundary;

import br.com.imerljak.concessionarias.entity.Responsavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("/responsaveis")
public class RepresentanteController {

    private RepresentanteRepository repository;

    @Autowired
    public RepresentanteController(RepresentanteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/novo")
    public ModelAndView createRepresentante() {

        ModelAndView modelAndView = new ModelAndView("responsaveis/create");
        modelAndView.addObject("representante", new Responsavel());

        return modelAndView;
    }

    @PostMapping("/novo")
    public String saveRepresentante(Responsavel responsavel, RedirectAttributes redirectAttributes) {
        repository.save(responsavel);

        redirectAttributes.addFlashAttribute("mensagem", "Responsavel gravado com sucesso!");

        return "redirect:/responsaveis";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editRepresentante(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("responsaveis/edit");
        modelAndView.addObject("representante", repository.findById(id));

        return modelAndView;
    }

    @PostMapping("/editar")
    public String saveEditedRepresentante(Responsavel responsavel, RedirectAttributes redirectAttributes) {
        repository.save(responsavel);
        redirectAttributes.addFlashAttribute("mensagem", "Responsavel alterado com sucesso!");
        return "redirect:/responsaveis";
    }

    @GetMapping("/remover/{id}")
    public String removeRepresentante(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Responsavel removido com sucesso!");
        return "redirect:/responsaveis";
    }

    @GetMapping("/{id}")
    public ModelAndView findRepresentante(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("responsaveis/view");
        modelAndView.addObject("representante", repository.findById(id));
        return modelAndView;
    }

    @GetMapping
    public ModelAndView listRepresentantes() {
        ModelAndView modelAndView = new ModelAndView("responsaveis/list");
        modelAndView.addObject("responsaveis", repository.findAll());
        return modelAndView;
    }

}
