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

import br.com.imerljak.concessionarias.entity.Concessionaria;
import br.com.imerljak.concessionarias.entity.Representante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/concessionarias")
public class ConcessionariaController {

    private ConcessionariaRepository repository;

    @Autowired
    public ConcessionariaController(ConcessionariaRepository repository) {
        this.repository = repository;
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

        System.out.println(concessionaria);
        System.out.println(concessionaria.getRepresentantes());

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
        modelAndView.addObject("concessionaria", repository.findById(id));
        return modelAndView;
    }

    @PostMapping("/editar")
    public String updateConcessionaria(@Validated Concessionaria concessionaria, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "redirect:/concessionarias/update";
        }

        repository.save(concessionaria);
        redirectAttributes.addFlashAttribute("mensagem", "Concessionária alterada com sucesso!");
        return "redirect:/concessionarias";
    }

    @GetMapping("/remover/{id}")
    public String removeConcessionaria(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Concessionária removida com sucesso!");
        return "redirect:/concessionarias";
    }

    @GetMapping("/{id}")
    public ModelAndView viewConcessionaria(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("concessionarias/view");
        modelAndView.addObject("concessionaria", repository.findById(id));
        return modelAndView;
    }

    @GetMapping
    public ModelAndView listConcessionarias() {
        ModelAndView modelAndView = new ModelAndView("concessionarias/list");
        modelAndView.addObject("concessionarias", repository.findAll());
        return modelAndView;
    }

}
