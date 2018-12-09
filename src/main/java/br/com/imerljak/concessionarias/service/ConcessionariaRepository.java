package br.com.imerljak.concessionarias.service;

import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {
    Optional<Concessionaria> findByCnpj(String cnpj);

    @Query("select o from Concessionaria o where o.nome like :query or o.email like :query or o.cnpj like :query or o.endereco like :query or o.telefone like :query")
    Page<Concessionaria> search(@Param("query") String query, Pageable pageable);

    @Query("select o.ouvidorias from Concessionaria o where o.id = :id")
    Page<Ouvidoria> findAllOuvidoriasOf(@Param("id") Long id, Pageable pageable);
}
