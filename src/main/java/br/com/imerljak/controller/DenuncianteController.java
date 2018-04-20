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
import br.com.imerljak.domain.Denunciante;
import br.com.imerljak.repository.DenuncianteRepository;
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
@Path("denunciante")
public class DenuncianteController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private DenuncianteRepository repository;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyDenunciante() {
        return "denunciante/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createDenunciante(@Valid
            @BeanParam Denunciante denunciante) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(denunciante);
        return "redirect:denunciante/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editDenunciante(@PathParam("id") Long id) {
        model.put("DENUNCIANTE", repository.find(id));
        return "denunciante/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateDenunciante(@Valid
            @BeanParam Denunciante denunciante) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(denunciante);
        return "redirect:denunciante/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeDenunciante(@PathParam("id") Long id) {
        repository.remove(repository.find(id));
        return "redirect:denunciante/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findDenunciante(@PathParam("id") Long id) {
        model.put("DENUNCIANTE", repository.find(id));
        return "denunciante/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllDenunciante() {
        model.put("DENUNCIANTE_LIST", repository.findAll());
        return "denunciante/list.jsp";
    }

}