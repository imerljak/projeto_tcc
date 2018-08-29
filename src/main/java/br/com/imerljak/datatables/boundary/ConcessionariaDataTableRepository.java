package br.com.imerljak.datatables.boundary;

import br.com.imerljak.concessionarias.entity.Concessionaria;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface ConcessionariaDataTableRepository extends DataTablesRepository<Concessionaria, Long> {
}
