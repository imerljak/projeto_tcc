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
import br.com.imerljak.domain.TramiteProcesso;
import br.com.imerljak.repository.TramiteProcessoRepository;
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
@Path("tramiteProcesso")
public class TramiteProcessoController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private TramiteProcessoRepository repository;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyTramiteProcesso() {
        return "tramiteProcesso/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createTramiteProcesso(@Valid
            @BeanParam TramiteProcesso tramiteProcesso) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(tramiteProcesso);
        return "redirect:tramiteProcesso/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editTramiteProcesso(@PathParam("id") Long id) {
        model.put("TRAMITEPROCESSO", repository.find(id));
        return "tramiteProcesso/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateTramiteProcesso(@Valid
            @BeanParam TramiteProcesso tramiteProcesso) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(tramiteProcesso);
        return "redirect:tramiteProcesso/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeTramiteProcesso(@PathParam("id") Long id) {
        repository.remove(repository.find(id));
        return "redirect:tramiteProcesso/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findTramiteProcesso(@PathParam("id") Long id) {
        model.put("TRAMITEPROCESSO", repository.find(id));
        return "tramiteProcesso/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllTramiteProcesso() {
        model.put("TRAMITEPROCESSO_LIST", repository.findAll());
        return "tramiteProcesso/list.jsp";
    }

}
