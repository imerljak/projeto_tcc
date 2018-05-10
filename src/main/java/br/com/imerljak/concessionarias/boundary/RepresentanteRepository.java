package br.com.imerljak.concessionarias.boundary;

import br.com.imerljak.concessionarias.entity.Representante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentanteRepository extends JpaRepository<Representante, Long> {
}
