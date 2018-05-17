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
package br.com.imerljak.concessionarias.boundary;

import br.com.imerljak.concessionarias.entity.Representante;
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
@RequestMapping("/representantes")
public class RepresentanteController {

    private RepresentanteRepository repository;

    @Autowired
    public RepresentanteController(RepresentanteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/novo")
    public ModelAndView createRepresentante() {

        ModelAndView modelAndView = new ModelAndView("representantes/create");
        modelAndView.addObject("representante", new Representante());

        return modelAndView;
    }

    @PostMapping("/novo")
    public String saveRepresentante(Representante representante, RedirectAttributes redirectAttributes) {
        repository.save(representante);

        redirectAttributes.addFlashAttribute("mensagem", "Representante gravado com sucesso!");

        return "redirect:/representantes";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editRepresentante(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("representantes/edit");
        modelAndView.addObject("representante", repository.findById(id));

        return modelAndView;
    }

    @PostMapping("/editar")
    public String saveEditedRepresentante(Representante representante, RedirectAttributes redirectAttributes) {
        repository.save(representante);
        redirectAttributes.addFlashAttribute("mensagem", "Representante alterado com sucesso!");
        return "redirect:/representantes";
    }

    @GetMapping("/remover/{id}")
    public String removeRepresentante(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Representante removido com sucesso!");
        return "redirect:/representantes";
    }

    @GetMapping("/{id}")
    public ModelAndView findRepresentante(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("representantes/view");
        modelAndView.addObject("representante", repository.findById(id));
        return modelAndView;
    }

    @GetMapping
    public ModelAndView listRepresentantes() {
        ModelAndView modelAndView = new ModelAndView("representantes/list");
        modelAndView.addObject("representantes", repository.findAll());
        return modelAndView;
    }

}
