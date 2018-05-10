package br.com.imerljak.denuncias.boundary;

import br.com.imerljak.denuncias.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
}
