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
package br.com.imerljak.processos.boundary;

import br.com.imerljak.processos.entity.Documento;
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

    @GetMapping("/new")
    public ModelAndView emptyDocumento() {
        ModelAndView modelAndView = new ModelAndView("documentos/create");
        modelAndView.addObject("documento", new Documento());
        return modelAndView;
    }

    @PostMapping("/new")
    public String createDocumento(@Validated Documento documento, RedirectAttributes redirectAttributes) {
        repository.save(documento);
        redirectAttributes.addFlashAttribute("mensagem", "Documento criado com sucesso!");
        return "redirect:documentos";
    }

    @GetMapping("/update/{id}")
    public ModelAndView editDocumento(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("documentos/update");
        modelAndView.addObject("documento", repository.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateDocumento(@Validated Documento documento, RedirectAttributes redirectAttributes) {
        repository.save(documento);
        redirectAttributes.addFlashAttribute("mensagem", "Documento atualizado com sucesso!");
        return "redirect:documentos";
    }

    @GetMapping("/remove/{id}")
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
