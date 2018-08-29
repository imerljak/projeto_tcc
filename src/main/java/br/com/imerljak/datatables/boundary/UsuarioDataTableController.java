package br.com.imerljak.datatables.boundary;

import br.com.imerljak.usuarios.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/datatable")
public class UsuarioDataTableController {

    private final UsuarioDataTableRepository usuarioRepository;
    private final ConcessionariaDataTableRepository concessionariaRepository;

    @Autowired
    public UsuarioDataTableController(UsuarioDataTableRepository usuarioRepository, ConcessionariaDataTableRepository concessionariaRepository) {this.usuarioRepository = usuarioRepository;
        this.concessionariaRepository = concessionariaRepository;
    }

    @GetMapping("/usuarios")
    public DataTablesOutput<Usuario> getUsuarios(@Valid DataTablesInput input) {
        return usuarioRepository.findAll(input);
    }

}

