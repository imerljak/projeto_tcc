package br.com.imerljak.denuncias.boundary;

import br.com.imerljak.concessionarias.boundary.ConcessionariaRepository;
import br.com.imerljak.denuncias.entity.Denuncia;
import br.com.imerljak.denuncias.entity.Denunciante;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Slf4j
@Controller
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService denunciaService;
    private final ConcessionariaRepository concessionariaRepository;

    @Autowired
    public DenunciaController(DenunciaService service, ConcessionariaRepository concessionariaRepository) {
        this.denunciaService = service;
        this.concessionariaRepository = concessionariaRepository;
    }

    // == private methods ==

    @ModelAttribute
    public void atributos(Model model) {
        model.addAttribute("concessionarias", concessionariaRepository.findAll());
    }

    // == model attributes ==

    @GetMapping
    public ModelAndView findAllDenuncia(@PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("denuncias/list");
        modelAndView.addObject("denuncias", denunciaService.findAll(pageable));
        return modelAndView;
    }

    // == list ==

    @GetMapping("/adicionar")
    public ModelAndView formCadastroDenuncia() {
        ModelAndView modelAndView = new ModelAndView("denuncias/create");
        modelAndView.addObject("denuncia", novaDenuncia());
        return modelAndView;
    }

    // == create ==

    private Object novaDenuncia() {
        Denuncia denuncia = new Denuncia();
        denuncia.setDenunciante(new Denunciante());
        return denuncia;
    }

    @PostMapping("/adicionar")
    public String postNovaDenuncia(@Validated Denuncia denuncia, @RequestParam("anexos_files") MultipartFile file, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("Nova Denuncia = {}", denuncia);
        log.info("files = {}", file);

        if (bindingResult.hasErrors()) {
            log.info("validation errors = {}", bindingResult.getAllErrors());
            return "/denuncias/create";
        }

        denunciaService.save(denuncia);
        redirectAttributes.addFlashAttribute("mensagem", "Denuncia salva com sucesso!");
        return "redirect:/denuncias";
    }

    // == update ==

    @GetMapping("/editar/{id}")
    public ModelAndView formEditarDenuncia(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("denuncias/update");
        modelAndView.addObject("denuncia", denunciaService.findById(id));
        return modelAndView;
    }

    @PutMapping("/editar")
    public String putAlterarDenuncia(@Validated Denuncia denuncia, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.debug("errors = {}", bindingResult.getAllErrors());
            return "/denuncias/editar/" + denuncia.getId();
        }

        denunciaService.save(denuncia);
        redirectAttributes.addFlashAttribute("mensagem", "Denuncia atualizada com sucesso!");
        return "redirect:/denuncias";
    }

    // == delete ==

    @DeleteMapping("/remover")
    public String deleteDenuncia(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        denunciaService.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Denuncia removida com sucesso!");
        return "redirect:/denuncias";
    }

    // == view ==

    @GetMapping("/{id}")
    public ModelAndView viewDenuncia(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("denuncias/view");
        modelAndView.addObject("denuncia", denunciaService.findById(id));
        return modelAndView;
    }


}
