package br.com.imerljak.login.boundary;

import br.com.imerljak.usuarios.boundary.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
