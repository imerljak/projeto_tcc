package br.com.imerljak.usuarios.service;

import br.com.imerljak.usuarios.model.Cargo;
import br.com.imerljak.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Boolean existsByEmail(String email);

    List<Usuario> findAllByCargosIn(List<Cargo> cargos);

}
