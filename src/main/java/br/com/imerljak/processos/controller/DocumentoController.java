package br.com.imerljak.processos.controller;

import br.com.imerljak.processos.model.Documento;
import br.com.imerljak.processos.service.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/documentos")
public class DocumentoController {

    private DocumentoRepository repository;

    @Autowired
    public DocumentoController(DocumentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/adicionar")
    public ModelAndView emptyDocumento() {
        ModelAndView modelAndView = new ModelAndView("documentos/create");
        modelAndView.addObject("documento", new Documento());
        return modelAndView;
    }

    @PostMapping("/adicionar")
    public String createDocumento(@Validated Documento documento, RedirectAttributes redirectAttributes) {
        repository.save(documento);
        redirectAttributes.addFlashAttribute("mensagem", "Documento criado com sucesso!");
        return "redirect:documentos";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editDocumento(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("documentos/update");
        modelAndView.addObject("documento", repository.findById(id));
        return modelAndView;
    }

    @PostMapping("/editar")
    public String updateDocumento(@Validated Documento documento, RedirectAttributes redirectAttributes) {
        repository.save(documento);
        redirectAttributes.addFlashAttribute("mensagem", "Documento atualizado com sucesso!");
        return "redirect:documentos";
    }

    @GetMapping("/remover/{id}")
    public String removeDocumento(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:documentos";
    }

    @GetMapping("/{id}")
    public ModelAndView findDocumento(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("documentos/view");
        modelAndView.addObject("documento", repository.findById(id));
        return modelAndView;
    }

    @GetMapping
    public ModelAndView findAllDocumento() {
        ModelAndView modelAndView = new ModelAndView("documentos/list");
        modelAndView.addObject("documentos", repository.findAll());
        return modelAndView;
    }

}
