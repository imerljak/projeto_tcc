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

import br.com.imerljak.processos.entity.Processo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("/processos")
public class ProcessoController {

    private ProcessoRepository repository;

    @Autowired
    public ProcessoController(ProcessoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ModelAndView findAllProcesso(@PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("processos/list");
        modelAndView.addObject("processos", repository.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView emptyProcesso() {
        ModelAndView modelAndView = new ModelAndView("processos/create");
        modelAndView.addObject("processo", new Processo());
        return modelAndView;
    }

    @PostMapping("/novo")
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

    @GetMapping("/remover/{id}")
    public String removeProcesso(@PathParam("id") Long id) {
        repository.deleteById(id);
        return "redirect:processos";
    }

    @GetMapping("/{id}")
    public ModelAndView findProcesso(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("processos/view");
        modelAndView.addObject("processo", repository.findById(id));
        return modelAndView;
    }

}
