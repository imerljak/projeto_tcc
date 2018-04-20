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
import br.com.imerljak.domain.AnexoTramite;
import br.com.imerljak.repository.AnexoTramiteRepository;
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
@Path("anexoTramite")
public class AnexoTramiteController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private AnexoTramiteRepository repository;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyAnexoTramite() {
        return "anexoTramite/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createAnexoTramite(@Valid
            @BeanParam AnexoTramite anexoTramite) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(anexoTramite);
        return "redirect:anexoTramite/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editAnexoTramite(@PathParam("id") Long id) {
        model.put("ANEXOTRAMITE", repository.find(id));
        return "anexoTramite/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateAnexoTramite(@Valid
            @BeanParam AnexoTramite anexoTramite) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(anexoTramite);
        return "redirect:anexoTramite/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeAnexoTramite(@PathParam("id") Long id) {
        repository.remove(repository.find(id));
        return "redirect:anexoTramite/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findAnexoTramite(@PathParam("id") Long id) {
        model.put("ANEXOTRAMITE", repository.find(id));
        return "anexoTramite/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllAnexoTramite() {
        model.put("ANEXOTRAMITE_LIST", repository.findAll());
        return "anexoTramite/list.jsp";
    }

}