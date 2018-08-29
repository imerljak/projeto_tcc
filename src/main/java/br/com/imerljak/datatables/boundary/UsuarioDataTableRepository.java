package br.com.imerljak.datatables.boundary;

import br.com.imerljak.usuarios.entity.Usuario;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface UsuarioDataTableRepository extends DataTablesRepository<Usuario, Long> {
}
