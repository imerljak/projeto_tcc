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
package br.com.imerljak.denuncias.boundary;

import br.com.imerljak.denuncias.entity.Denuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping("/denuncias")
public class DenunciaController {

    private DenunciaRepository repository;


    @GetMapping
    public ModelAndView findAllDenuncia(@PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("denuncias/list");
        modelAndView.addObject("denuncias", repository.findAll(pageable));
        return modelAndView;
    }

    @Autowired
    public DenunciaController(DenunciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/adicionar")
    public ModelAndView emptyDenuncia() {
        ModelAndView modelAndView = new ModelAndView("denuncias/create");
        modelAndView.addObject("denuncia", new Denuncia());
        return modelAndView;
    }

    @PostMapping("/adicionar")
    public String createDenuncia(@Validated Denuncia denuncia, RedirectAttributes redirectAttributes) {
        repository.save(denuncia);
        redirectAttributes.addFlashAttribute("mensagem", "Denuncia salva com sucesso!");
        return "redirect:denuncias";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editDenuncia(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("denuncias/update");
        modelAndView.addObject("denuncia", repository.findById(id));
        return modelAndView;
    }

    @PostMapping("/editar")
    public String updateDenuncia(@Validated Denuncia denuncia, RedirectAttributes redirectAttributes) {
        repository.save(denuncia);
        redirectAttributes.addFlashAttribute("mensagem", "Denuncia atualizada com sucesso!");
        return "redirect:denuncias";
    }

    @GetMapping("/remover/{id}")
    public String removeDenuncia(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Denuncia removida com sucesso!");
        return "redirect:denuncias";
    }

    @GetMapping("/{id}")
    public ModelAndView findDenuncia(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("denuncias/view");
        modelAndView.addObject("denuncia", repository.findById(id));
        return modelAndView;
    }

}
