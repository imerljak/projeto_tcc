package br.com.imerljak.usuarios.boundary;

import br.com.imerljak.usuarios.entity.Cargo;
import br.com.imerljak.usuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Boolean existsByEmail(String email);

    List<Usuario> findAllByCargosIn(List<Cargo> cargos);

}
