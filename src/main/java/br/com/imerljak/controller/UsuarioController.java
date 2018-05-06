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
package br.com.imerljak.controller;

import br.com.imerljak.domain.Usuario;
import br.com.imerljak.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestScope
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    // TODO: 20/04/18 convert to Spring

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String emptyUsuario() {

//        Usuario usuario = new Usuario();
//        usuario.setNome("Israel Merljak");
//        usuario.setEmail("imerljak@gmail.com");
//        usuario.setSenha("12345");
//
//        repository.save(usuario);

        return "usuario/create";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String createUsuario(Usuario usuario) { // TODO: @Valid
        repository.save(usuario);
        return "redirect:usuario/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView editUsuario(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("usuario/update");
        modelAndView.addObject("usuario", repository.findById(id));
        return modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateusuario(Usuario usuario) { // TODO: @Valid
        repository.save(usuario);
        return "redirect:usuario/list";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String removeUsuario(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:usuario/list";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView findUsuario(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("usuario/view");
        modelAndView.addObject("usuario", repository.findById(id));
        return modelAndView;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView findAllUsuarios() {
        ModelAndView modelAndView = new ModelAndView("usuario/list");
        modelAndView.addObject("usuarios", repository.findAll()); // TODO: Paginate ?
        return modelAndView;
    }
}
