package br.com.imerljak.usuarios.controller;

import br.com.imerljak.usuarios.exception.UsuarioNotFoundException;
import br.com.imerljak.usuarios.model.Usuario;
import br.com.imerljak.usuarios.service.CargoRepository;
import br.com.imerljak.usuarios.service.UsuarioService;
import br.com.imerljak.visao.AlertMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@SessionScope
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService service;
    private CargoRepository cargoRepository;

    @Autowired
    public UsuarioController(UsuarioService service, CargoRepository cargoRepository) {
        this.service = service;
        this.cargoRepository = cargoRepository;
    }

    @GetMapping
    public ModelAndView listaUsuarios(@PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("usuarios/list");
        modelAndView.addObject("usuarios", service.findAll(pageable));
        return modelAndView;
    }

    @GetMapping(value = "/adicionar")
    public ModelAndView novoUsuarioForm() {
        ModelAndView modelAndView = new ModelAndView("usuarios/create");
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.addObject("cargos", cargoRepository.findAll());
        return modelAndView;
    }

    @PostMapping(value = "/adicionar")
    public String registraNovoUsuario(@Validated Usuario usuario, BindingResult bindingResult, RedirectAttributes attributes) {

        if (service.existsByEmail(usuario.getEmail())) {
            bindingResult.rejectValue("email", "Unique.usuario.email");
        }

        if (bindingResult.hasErrors()) {
            return "usuarios/create";
        }

        service.save(usuario);

        attributes.addFlashAttribute("message", "Usuário adicionado com sucesso!");
        return "redirect:/usuarios";
    }

    @GetMapping(value = "/editar/{id}")
    public ModelAndView editaUsuarioForm(@PathVariable Long id) {

        Usuario usuario = service.findById(id).orElseThrow(UsuarioNotFoundException::new);

        ModelAndView modelAndView = new ModelAndView("usuarios/update");
        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("cargos", cargoRepository.findAll());
        return modelAndView;
    }

    @PutMapping(value = "/editar")
    public String salvaEdicaoUsuario(@Validated Usuario usuario, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/usuarios/update";
        }

        service.save(usuario);

        return "redirect:/usuarios";
    }

    @DeleteMapping(value = "/remover")
    public String removeUsuario(Long id, RedirectAttributes redirectAttributes) {

        final Usuario one = service.getOne(id);
        one.setAtivo(false);
        service.save(one);

        redirectAttributes.addFlashAttribute("alert", AlertMessage.with()
                .status(AlertMessage.Status.SUCCESS)
                .message("Usuário desativado com sucesso!")
                .build());

        return "redirect:/usuarios";
    }

}
