package br.com.imerljak.denuncias.boundary;

import br.com.imerljak.denuncias.entity.Denunciante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenuncianteRepository extends JpaRepository<Denunciante, Long> {

}
