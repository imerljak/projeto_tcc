package br.com.imerljak.concessionarias.boundary;

import br.com.imerljak.concessionarias.entity.Concessionaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {

}
