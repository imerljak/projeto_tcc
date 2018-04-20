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

import br.com.imerljak.repository.TipoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("/tipoServico")
public class TipoServicoController {

    private TipoServicoRepository repository;

    @Autowired
    public TipoServicoController(TipoServicoRepository repository) {
        this.repository = repository;
    }

    // TODO: 20/04/18 COnvert to Spring

//    @GET
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    public String emptyTipoServico() {
//        return "tipoServico/create.jsp";
//    }
//
//    @POST
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String createTipoServico(@Valid
//            @BeanParam TipoServico tipoServico) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.create(tipoServico);
//        return "redirect:tipoServico/list";
//    }
//
//    @GET
//    @Path("update/{id}")
//    @javax.mvc.annotation.Controller
//    public String editTipoServico(@PathParam("id") Long id) {
//        model.put("TIPOSERVICO", repository.find(id));
//        return "tipoServico/update.jsp";
//    }
//
//    @POST
//    @Path("update")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String updateTipoServico(@Valid
//            @BeanParam TipoServico tipoServico) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.edit(tipoServico);
//        return "redirect:tipoServico/list";
//    }
//
//    @GET
//    @Path("remove/{id}")
//    @javax.mvc.annotation.Controller
//    public String removeTipoServico(@PathParam("id") Long id) {
//        repository.remove(repository.find(id));
//        return "redirect:tipoServico/list";
//    }
//
//    @GET
//    @Path("{id}")
//    @javax.mvc.annotation.Controller
//    public String findTipoServico(@PathParam("id") Long id) {
//        model.put("TIPOSERVICO", repository.find(id));
//        return "tipoServico/view.jsp";
//    }
//
//    @GET
//    @Path("list")
//    @javax.mvc.annotation.Controller
//    public String findAllTipoServico() {
//        model.put("TIPOSERVICO_LIST", repository.findAll());
//        return "tipoServico/list.jsp";
//    }

}
