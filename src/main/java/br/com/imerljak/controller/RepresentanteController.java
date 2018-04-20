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

import br.com.imerljak.repository.RepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("/representante")
public class RepresentanteController {

    private RepresentanteRepository repository;

    @Autowired
    public RepresentanteController(RepresentanteRepository repository) {
        this.repository = repository;
    }

    // TODO: 20/04/18 Convert to Spring

//    @GET
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    public String emptyRepresentante() {
//        return "representante/create.jsp";
//    }
//
//    @POST
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String createRepresentante(@Valid
//            @BeanParam Representante representante) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.create(representante);
//        return "redirect:representante/list";
//    }
//
//    @GET
//    @Path("update/{id}")
//    @javax.mvc.annotation.Controller
//    public String editRepresentante(@PathParam("id") Long id) {
//        model.put("REPRESENTANTE", repository.find(id));
//        return "representante/update.jsp";
//    }
//
//    @POST
//    @Path("update")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String updateRepresentante(@Valid
//            @BeanParam Representante representante) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.edit(representante);
//        return "redirect:representante/list";
//    }
//
//    @GET
//    @Path("remove/{id}")
//    @javax.mvc.annotation.Controller
//    public String removeRepresentante(@PathParam("id") Long id) {
//        repository.remove(repository.find(id));
//        return "redirect:representante/list";
//    }
//
//    @GET
//    @Path("{id}")
//    @javax.mvc.annotation.Controller
//    public String findRepresentante(@PathParam("id") Long id) {
//        model.put("REPRESENTANTE", repository.find(id));
//        return "representante/view.jsp";
//    }
//
//    @GET
//    @Path("list")
//    @javax.mvc.annotation.Controller
//    public String findAllRepresentante() {
//        model.put("REPRESENTANTE_LIST", repository.findAll());
//        return "representante/list.jsp";
//    }

}
