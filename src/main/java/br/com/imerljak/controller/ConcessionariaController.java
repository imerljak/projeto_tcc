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

import br.com.imerljak.controller.util.ErrorBean;
import br.com.imerljak.controller.util.ValidationUtil;
import br.com.imerljak.domain.Concessionaria;
import br.com.imerljak.repository.ConcessionariaRepository;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Path("concessionaria")
public class ConcessionariaController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private ConcessionariaRepository repository;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyConcessionaria() {
        return "concessionaria/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createConcessionaria(@Valid
            @BeanParam Concessionaria concessionaria) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(concessionaria);
        return "redirect:concessionaria/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editConcessionaria(@PathParam("id") Long id) {
        model.put("CONCESSIONARIA", repository.find(id));
        return "concessionaria/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateConcessionaria(@Valid
            @BeanParam Concessionaria concessionaria) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(concessionaria);
        return "redirect:concessionaria/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeConcessionaria(@PathParam("id") Long id) {
        repository.remove(repository.find(id));
        return "redirect:concessionaria/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findConcessionaria(@PathParam("id") Long id) {
        model.put("CONCESSIONARIA", repository.find(id));
        return "concessionaria/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllConcessionaria() {
        model.put("CONCESSIONARIA_LIST", repository.findAll());
        return "concessionaria/list.jsp";
    }

}
