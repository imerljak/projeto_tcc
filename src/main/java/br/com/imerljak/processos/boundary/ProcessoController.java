package br.com.imerljak.processos.boundary;

import br.com.imerljak.concessionarias.boundary.ConcessionariaRepository;
import br.com.imerljak.processos.entity.Processo;
import br.com.imerljak.usuarios.boundary.UsuarioRepository;
import br.com.imerljak.usuarios.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
import java.util.Collections;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("/processos")
public class ProcessoController {

    private final ProcessoRepository repository;
    private final ConcessionariaRepository concessionariaRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ProcessoController(ProcessoRepository repository, ConcessionariaRepository concessionariaRepository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.concessionariaRepository = concessionariaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ModelAndView findAllProcesso(@PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("processos/list");
        modelAndView.addObject("processos", repository.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/adicionar")
    public ModelAndView emptyProcesso() {
        ModelAndView modelAndView = new ModelAndView("processos/create");
        modelAndView.addObject("processo", new Processo());
        modelAndView.addObject("concessionarias", concessionariaRepository.findAll());
        modelAndView.addObject("revisoresRelatores",
                               usuarioRepository.findAllByCargosIn(Collections.singletonList(Cargo.REVISOR_RELATOR)));
        return modelAndView;
    }

    @PostMapping("/adicionar")
    public String createProcesso(@Validated Processo processo, RedirectAttributes redirectAttributes) {
        repository.save(processo);
        redirectAttributes.addFlashAttribute("mensagem", "Processo criado com sucesso!");
        return "redirect:processos";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editProcesso(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("processos/update.jsp");
        modelAndView.addObject("processo", repository.findById(id));
        return modelAndView;
    }

    @PostMapping("/editar")
    public String updateProcesso(@Validated Processo processo, RedirectAttributes redirectAttributes) {
        repository.save(processo);
        redirectAttributes.addFlashAttribute("mensagem", "Processo atualizado com sucesso!");
        return "redirect:processos";
    }

    @GetMapping("/remover")
    public String removeProcesso(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {

        //TODO: Validar se pode remover.

        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Processo removido com sucesso.");
        return "redirect:processos";
    }

    @GetMapping("/{id}")
    public ModelAndView findProcesso(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("processos/view");
        modelAndView.addObject("processo", repository.findById(id));
        return modelAndView;
    }

}
