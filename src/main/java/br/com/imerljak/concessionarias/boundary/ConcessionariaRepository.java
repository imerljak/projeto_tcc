package br.com.imerljak.concessionarias.boundary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imerljak.concessionarias.entity.Concessionaria;

public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {

    Optional<Concessionaria> findByCnpj(String cnpj);

}
