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

import br.com.imerljak.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("tipoDocumento")
public class TipoDocumentoController {

    private TipoDocumentoRepository repository;

    @Autowired
    public TipoDocumentoController(TipoDocumentoRepository repository) {
        this.repository = repository;
    }

    // TODO: 20/04/18 Convert to Spring

//    @GET
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    public String emptyTipoDocumento() {
//        return "tipoDocumento/create.jsp";
//    }
//
//    @POST
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String createTipoDocumento(@Valid
//            @BeanParam TipoDocumento tipoDocumento) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.create(tipoDocumento);
//        return "redirect:tipoDocumento/list";
//    }
//
//    @GET
//    @Path("update/{id}")
//    @javax.mvc.annotation.Controller
//    public String editTipoDocumento(@PathParam("id") Long id) {
//        model.put("TIPODOCUMENTO", repository.find(id));
//        return "tipoDocumento/update.jsp";
//    }
//
//    @POST
//    @Path("update")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String updateTipoDocumento(@Valid
//            @BeanParam TipoDocumento tipoDocumento) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.edit(tipoDocumento);
//        return "redirect:tipoDocumento/list";
//    }
//
//    @GET
//    @Path("remove/{id}")
//    @javax.mvc.annotation.Controller
//    public String removeTipoDocumento(@PathParam("id") Long id) {
//        repository.remove(repository.find(id));
//        return "redirect:tipoDocumento/list";
//    }
//
//    @GET
//    @Path("{id}")
//    @javax.mvc.annotation.Controller
//    public String findTipoDocumento(@PathParam("id") Long id) {
//        model.put("TIPODOCUMENTO", repository.find(id));
//        return "tipoDocumento/view.jsp";
//    }
//
//    @GET
//    @Path("list")
//    @javax.mvc.annotation.Controller
//    public String findAllTipoDocumento() {
//        model.put("TIPODOCUMENTO_LIST", repository.findAll());
//        return "tipoDocumento/list.jsp";
//    }

}
