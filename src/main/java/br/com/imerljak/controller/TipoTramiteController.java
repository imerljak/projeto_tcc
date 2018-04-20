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

import br.com.imerljak.repository.TipoTramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("/tipoTramite")
public class TipoTramiteController {

    private TipoTramiteRepository repository;

    @Autowired
    public TipoTramiteController(TipoTramiteRepository repository) {
        this.repository = repository;
    }

    // TODO: 20/04/18 Convert to Spring

//    @GET
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    public String emptyTipoTramite() {
//        return "tipoTramite/create.jsp";
//    }
//
//    @POST
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String createTipoTramite(@Valid
//            @BeanParam TipoTramite tipoTramite) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.create(tipoTramite);
//        return "redirect:tipoTramite/list";
//    }
//
//    @GET
//    @Path("update/{id}")
//    @javax.mvc.annotation.Controller
//    public String editTipoTramite(@PathParam("id") Long id) {
//        model.put("TIPOTRAMITE", repository.find(id));
//        return "tipoTramite/update.jsp";
//    }
//
//    @POST
//    @Path("update")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String updateTipoTramite(@Valid
//            @BeanParam TipoTramite tipoTramite) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.edit(tipoTramite);
//        return "redirect:tipoTramite/list";
//    }
//
//    @GET
//    @Path("remove/{id}")
//    @javax.mvc.annotation.Controller
//    public String removeTipoTramite(@PathParam("id") Long id) {
//        repository.remove(repository.find(id));
//        return "redirect:tipoTramite/list";
//    }
//
//    @GET
//    @Path("{id}")
//    @javax.mvc.annotation.Controller
//    public String findTipoTramite(@PathParam("id") Long id) {
//        model.put("TIPOTRAMITE", repository.find(id));
//        return "tipoTramite/view.jsp";
//    }
//
//    @GET
//    @Path("list")
//    @javax.mvc.annotation.Controller
//    public String findAllTipoTramite() {
//        model.put("TIPOTRAMITE_LIST", repository.findAll());
//        return "tipoTramite/list.jsp";
//    }

}
