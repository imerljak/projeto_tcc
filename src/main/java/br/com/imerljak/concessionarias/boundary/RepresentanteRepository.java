package br.com.imerljak.concessionarias.boundary;

import br.com.imerljak.concessionarias.entity.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentanteRepository extends JpaRepository<Responsavel, Long> {
}
