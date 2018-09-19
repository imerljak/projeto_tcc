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

import br.com.imerljak.concessionarias.boundary.ConcessionariaRepository;
import br.com.imerljak.denuncias.entity.Denuncia;
import br.com.imerljak.denuncias.entity.Denunciante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService denunciaService;
    private final ConcessionariaRepository concessionariaRepository;

    @Autowired
    public DenunciaController(DenunciaService repository, ConcessionariaRepository concessionariaRepository) {
        this.denunciaService = repository;
        this.concessionariaRepository = concessionariaRepository;
    }

    // == private methods ==

    private Object novaDenuncia() {
        Denuncia denuncia = new Denuncia();
        denuncia.setDenunciante(new Denunciante());
        return denuncia;
    }

    // == model attributes ==

    @ModelAttribute
    public void atributos(Model model) {
        model.addAttribute("concessionarias", concessionariaRepository.findAll());
    }

    // == list ==

    @GetMapping
    public ModelAndView findAllDenuncia(@PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("denuncias/list");
        modelAndView.addObject("denuncias", denunciaService.findAll(pageable));
        return modelAndView;
    }

    // == create ==

    @GetMapping("/adicionar")
    public ModelAndView formCadastroDenuncia() {
        ModelAndView modelAndView = new ModelAndView("denuncias/create");
        modelAndView.addObject("denuncia", novaDenuncia());
        return modelAndView;
    }

    @PostMapping("/adicionar")
    public String postNovaDenuncia(@Validated Denuncia denuncia, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "/denuncias/create";
        }

        denunciaService.save(denuncia);
        redirectAttributes.addFlashAttribute("mensagem", "Denuncia salva com sucesso!");
        return "redirect:denuncias";
    }

    // == update ==

    @GetMapping("/editar/{id}")
    public ModelAndView formEditarDenuncia(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("denuncias/update");
        modelAndView.addObject("denuncia", denunciaService.findById(id));
        return modelAndView;
    }

    @PutMapping("/editar")
    public String putAlterarDenuncia(@Validated Denuncia denuncia, RedirectAttributes redirectAttributes) {
        denunciaService.save(denuncia);
        redirectAttributes.addFlashAttribute("mensagem", "Denuncia atualizada com sucesso!");
        return "redirect:denuncias";
    }

    // == delete ==

    @DeleteMapping("/remover/{id}")
    public String deleteDenuncia(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        denunciaService.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Denuncia removida com sucesso!");
        return "redirect:denuncias";
    }

    // == view ==

    @GetMapping("/{id}")
    public ModelAndView viewDenuncia(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("denuncias/view");
        modelAndView.addObject("denuncia", denunciaService.findById(id));
        return modelAndView;
    }


}
