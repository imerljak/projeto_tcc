package br.com.imerljak.denuncias.boundary;

import br.com.imerljak.denuncias.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    Integer countDenunciasByDataCriacaoAfter(LocalDateTime dateTime);

    Integer countDenunciasByDataCriacaoBetween(LocalDateTime start, LocalDateTime end);

}
