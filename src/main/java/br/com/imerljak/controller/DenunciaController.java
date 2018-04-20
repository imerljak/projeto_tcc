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

import br.com.imerljak.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@ConditionalOnBean
@RequestMapping("/denuncia")
public class DenunciaController {

    private DenunciaRepository repository;

    @Autowired
    public DenunciaController(DenunciaRepository repository) {
        this.repository = repository;
    }

//    @GET
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    public String emptyDenuncia() {
//        return "denuncia/create.jsp";
//    }
//
//    @POST
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String createDenuncia(@Valid
//            @BeanParam Denuncia denuncia) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.create(denuncia);
//        return "redirect:denuncia/list";
//    }
//
//    @GET
//    @Path("update/{id}")
//    @javax.mvc.annotation.Controller
//    public String editDenuncia(@PathParam("id") Long id) {
//        model.put("DENUNCIA", repository.find(id));
//        return "denuncia/update.jsp";
//    }
//
//    @POST
//    @Path("update")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String updateDenuncia(@Valid
//            @BeanParam Denuncia denuncia) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.edit(denuncia);
//        return "redirect:denuncia/list";
//    }
//
//    @GET
//    @Path("remove/{id}")
//    @javax.mvc.annotation.Controller
//    public String removeDenuncia(@PathParam("id") Long id) {
//        repository.remove(repository.find(id));
//        return "redirect:denuncia/list";
//    }
//
//    @GET
//    @Path("{id}")
//    @javax.mvc.annotation.Controller
//    public String findDenuncia(@PathParam("id") Long id) {
//        model.put("DENUNCIA", repository.find(id));
//        return "denuncia/view.jsp";
//    }
//
//    @GET
//    @Path("list")
//    @javax.mvc.annotation.Controller
//    public String findAllDenuncia() {
//        model.put("DENUNCIA_LIST", repository.findAll());
//        return "denuncia/list.jsp";
//    }

}
