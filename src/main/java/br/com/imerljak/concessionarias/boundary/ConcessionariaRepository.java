package br.com.imerljak.concessionarias.boundary;

import br.com.imerljak.concessionarias.entity.Concessionaria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {
    Optional<Concessionaria> findByCnpj(String cnpj);
}
