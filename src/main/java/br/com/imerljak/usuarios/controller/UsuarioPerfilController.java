package br.com.imerljak.usuarios.controller;

import br.com.imerljak.usuarios.model.Usuario;
import br.com.imerljak.usuarios.service.CargoRepository;
import br.com.imerljak.usuarios.service.UsuarioRepository;
import br.com.imerljak.utils.Redirect;
import br.com.imerljak.visao.AlertMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Objects;

@RequestMapping("/perfil")
@Controller
public class UsuarioPerfilController {

    private final UsuarioRepository repository;
    private final CargoRepository cargoRepository;

    public UsuarioPerfilController(UsuarioRepository repository, CargoRepository cargoRepository) {
        this.repository = repository;
        this.cargoRepository = cargoRepository;
    }

    @GetMapping
    public ModelAndView findUsuario(ModelAndView modelAndView, Principal principal) {

        modelAndView.setViewName("usuarios/profile.html");
        modelAndView.addObject("usuario", repository.findByEmail(principal.getName()));
        modelAndView.addObject("cargos", cargoRepository.findAll());

        return modelAndView;
    }

    @PutMapping
    public String editaPerfil(Usuario usuario, RedirectAttributes ra, HttpServletRequest req, HttpServletResponse res, Authentication auth) {
        final Usuario one = repository.getOne(usuario.getId());

        final String oldEmail = one.getEmail();

        one.setEmail(usuario.getEmail());
        one.setNome(usuario.getNome());

        final Usuario savedOne = repository.save(one);

        if (!savedOne.getEmail().equals(oldEmail) && Objects.nonNull(auth)) {

            new SecurityContextLogoutHandler().logout(req, res, auth);

            ra.addFlashAttribute("alert",
                                 AlertMessage.with()
                                         .message("Seu email foi alterado. Por favor, entre novamente no sistema.")
                                         .build());

            return Redirect.to("/login");
        }

        return Redirect.to("/perfil");
    }

    @GetMapping("/alterar-senha")
    public String formAlterarSenha() {
        return "/usuarios/change-password";
    }

}
