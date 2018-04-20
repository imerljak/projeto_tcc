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

import br.com.imerljak.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Controller
@RequestMapping("/documento")
public class DocumentoController {

    private DocumentoRepository repository;

    @Autowired
    public DocumentoController(DocumentoRepository repository) {
        this.repository = repository;
    }

//    @GET
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    public String emptyDocumento() {
//        return "documento/create.jsp";
//    }
//
//    @POST
//    @Path("new")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String createDocumento(@Valid
//            @BeanParam Documento documento) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.create(documento);
//        return "redirect:documento/list";
//    }
//
//    @GET
//    @Path("update/{id}")
//    @javax.mvc.annotation.Controller
//    public String editDocumento(@PathParam("id") Long id) {
//        model.put("DOCUMENTO", repository.find(id));
//        return "documento/update.jsp";
//    }
//
//    @POST
//    @Path("update")
//    @javax.mvc.annotation.Controller
//    @ValidateOnExecution(type = ExecutableType.NONE)
//    public String updateDocumento(@Valid
//            @BeanParam Documento documento) {
//        if (validationResult.isFailed()) {
//            return ValidationUtil.getResponse(validationResult, error);
//        }
//        repository.edit(documento);
//        return "redirect:documento/list";
//    }
//
//    @GET
//    @Path("remove/{id}")
//    @javax.mvc.annotation.Controller
//    public String removeDocumento(@PathParam("id") Long id) {
//        repository.remove(repository.find(id));
//        return "redirect:documento/list";
//    }
//
//    @GET
//    @Path("{id}")
//    @javax.mvc.annotation.Controller
//    public String findDocumento(@PathParam("id") Long id) {
//        model.put("DOCUMENTO", repository.find(id));
//        return "documento/view.jsp";
//    }
//
//    @GET
//    @Path("list")
//    @javax.mvc.annotation.Controller
//    public String findAllDocumento() {
//        model.put("DOCUMENTO_LIST", repository.findAll());
//        return "documento/list.jsp";
//    }
//
}
