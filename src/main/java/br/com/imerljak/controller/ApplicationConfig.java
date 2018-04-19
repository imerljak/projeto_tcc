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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.mvc.engine.ViewEngine;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

/**
 *
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@ApplicationPath("resources")
@EmbeddedIdentityStoreDefinition(
        @Credentials(callerName = "user", password = "user"))
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(ViewEngine.VIEW_FOLDER, "/WEB-INF/views");
        return props;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.imerljak.controller.AnexoDenunciaController.class);
        resources.add(br.com.imerljak.controller.AnexoTramiteController.class);
        resources.add(br.com.imerljak.controller.ConcessionariaController.class);
        resources.add(br.com.imerljak.controller.DenunciaController.class);
        resources.add(br.com.imerljak.controller.DenuncianteController.class);
        resources.add(br.com.imerljak.controller.DocumentoController.class);
        resources.add(br.com.imerljak.controller.LoginController.class);
        resources.add(br.com.imerljak.controller.ProcessoController.class);
        resources.add(br.com.imerljak.controller.RepresentanteController.class);
        resources.add(br.com.imerljak.controller.TipoDocumentoController.class);
        resources.add(br.com.imerljak.controller.TipoProcessoController.class);
        resources.add(br.com.imerljak.controller.TipoServicoController.class);
        resources.add(br.com.imerljak.controller.TipoTramiteController.class);
        resources.add(br.com.imerljak.controller.TramiteDenunciaController.class);
        resources.add(br.com.imerljak.controller.TramiteProcessoController.class);
        resources.add(br.com.imerljak.controller.UsuarioController.class);
        resources.add(br.com.imerljak.controller.util.CustomParamConverterProvider.class);
    }

}
