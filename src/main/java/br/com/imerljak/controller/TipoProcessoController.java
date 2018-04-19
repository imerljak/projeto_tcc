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
import br.com.imerljak.domain.TipoProcesso;
import br.com.imerljak.repository.TipoProcessoRepository;
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
@Path("tipoProcesso")
public class TipoProcessoController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private TipoProcessoRepository repository;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyTipoProcesso() {
        return "tipoProcesso/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createTipoProcesso(@Valid
            @BeanParam TipoProcesso tipoProcesso) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(tipoProcesso);
        return "redirect:tipoProcesso/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editTipoProcesso(@PathParam("id") Long id) {
        model.put("TIPOPROCESSO", repository.find(id));
        return "tipoProcesso/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateTipoProcesso(@Valid
            @BeanParam TipoProcesso tipoProcesso) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(tipoProcesso);
        return "redirect:tipoProcesso/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeTipoProcesso(@PathParam("id") Long id) {
        repository.remove(repository.find(id));
        return "redirect:tipoProcesso/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findTipoProcesso(@PathParam("id") Long id) {
        model.put("TIPOPROCESSO", repository.find(id));
        return "tipoProcesso/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllTipoProcesso() {
        model.put("TIPOPROCESSO_LIST", repository.findAll());
        return "tipoProcesso/list.jsp";
    }

}
