package br.com.imerljak.seguranca.controller;

import br.com.imerljak.usuarios.model.Cargo;
import br.com.imerljak.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        if (!usuarioService.haveUsers()) {
            usuarioService.createWith(
                    "Israel Merljak",
                    "imerljak@gmail.com",
                    "123456",
                    Arrays.asList(
                            Cargo.ADMINISTRADOR,
                            Cargo.GERENTE,
                            Cargo.ADMINISTRADOR
                    ));
        }

        return new ModelAndView("login");
    }
}
