/*
 * Copyright (C) 2018 Israel Merljak <imerljak@gmail.com.br>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.imerljak.usuarios.boundary;

import br.com.imerljak.usuarios.control.UsuarioNotFoundException;
import br.com.imerljak.usuarios.entity.Usuario;
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

    private UsuarioRepository repository;
    private CargoRepository cargoRepository;

    @Autowired
    public UsuarioController(UsuarioRepository repository, CargoRepository cargoRepository) {
        this.repository = repository;
        this.cargoRepository = cargoRepository;
    }

    @GetMapping
    public ModelAndView listaUsuarios(@PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("usuarios/list");
        modelAndView.addObject("usuarios", repository.findAll(pageable));
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

        if (repository.existsByEmail(usuario.getEmail())) {
            bindingResult.rejectValue("email", "Unique.usuario.email");
        }

        if (bindingResult.hasErrors()) {
            return "usuarios/create";
        }

        repository.save(usuario);

        attributes.addFlashAttribute("message", "Usuário adicionado com sucesso!");
        return "redirect:/usuarios";
    }

    @GetMapping(value = "/editar/{id}")
    public ModelAndView editaUsuarioForm(@PathVariable Long id) {

        Usuario usuario = repository.findById(id).orElseThrow(UsuarioNotFoundException::new);

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

        repository.findById(usuario.getId())
                .ifPresent(u -> {
                    u.setNome(usuario.getNome());
                    u.setEmail(usuario.getEmail());
                    u.setCargos(usuario.getCargos());

                    repository.save(u);
                });

        return "redirect:/usuarios";
    }

    @DeleteMapping(value = "/remover")
    public String removeUsuario(Long id, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Usuário removido com sucesso!");
        return "redirect:/usuarios";
    }

    @GetMapping(value = "/perfil/{id}")
    public ModelAndView findUsuario(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("usuarios/view");
        modelAndView.addObject("usuario", repository.findById(id));
        return modelAndView;
    }
}
