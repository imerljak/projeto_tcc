package br.com.imerljak.usuarios.boundary;

import br.com.imerljak.usuarios.entity.Cargo;
import br.com.imerljak.usuarios.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
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

    public Optional<Usuario> findByEmail(String email) {return usuarioRepository.findByEmail(email);}

    public boolean existsByEmail(String email) {return usuarioRepository.existsByEmail(email);}

    public Page<Usuario> findAll(Pageable pageable) {return usuarioRepository.findAll(pageable);}

    public <S extends Usuario> Usuario createWith(String nome, String email, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        usuario.setCargos(new HashSet<>(Collections.singleton(Cargo.ADMINISTRADOR)));

        return this.save(usuario);
    }

    public Usuario save(Usuario usuario) {

        if (usuario.isNew()) {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findById(Long id) {return usuarioRepository.findById(id);}

    public boolean existsById(Long id) {return usuarioRepository.existsById(id);}

    public void deleteById(Long id) {usuarioRepository.deleteById(id);}

    public void delete(Usuario usuario) {usuarioRepository.delete(usuario);}
}
