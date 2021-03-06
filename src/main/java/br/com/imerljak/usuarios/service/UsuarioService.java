package br.com.imerljak.usuarios.service;

import br.com.imerljak.usuarios.model.Cargo;
import br.com.imerljak.usuarios.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@Service
public class UsuarioService {

    private PasswordEncoder passwordEncoder;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getOne(Long aLong) {return usuarioRepository.getOne(aLong);}

    public Optional<Usuario> findByEmail(String email) {return usuarioRepository.findByEmail(email);}

    public boolean existsByEmail(String email) {return usuarioRepository.existsByEmail(email);}

    public Page<Usuario> findAll(Pageable pageable) {return usuarioRepository.findAll(pageable);}

    public void createWith(String nome, String email, String senha, Collection<Cargo> cargos) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.getCargos().addAll(cargos);

        if (!this.findByEmail(usuario.getEmail()).isPresent()) {
            this.save(usuario);
        }
    }

    public Usuario save(Usuario usuario) {

        if (usuario.isNew()) {
            encodePassword(usuario, usuario.getSenha());

        } else {
            Usuario usuarioExistente = findById(usuario.getId()).orElseThrow(EntityNotFoundException::new);

            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setCargos(usuario.getCargos());

            if (usuario.getSenha() != null && !usuarioExistente.getSenha().equals(usuario.getSenha())) {
                encodePassword(usuarioExistente, usuario.getSenha());
            }

            usuario = usuarioExistente;
        }

        return usuarioRepository.save(usuario);
    }

    private void encodePassword(Usuario usuario, String password) {
        usuario.setSenha(passwordEncoder.encode(password));
    }

    public Optional<Usuario> findById(Long id) {return usuarioRepository.findById(id);}

    public void deleteById(Long id) {usuarioRepository.deleteById(id);}

    public void delete(Usuario usuario) {usuarioRepository.delete(usuario);}

    public boolean haveUsers() {
        return usuarioRepository.count() > 0;
    }
}
