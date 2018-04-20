package br.com.imerljak.repository;

import br.com.imerljak.domain.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
}
