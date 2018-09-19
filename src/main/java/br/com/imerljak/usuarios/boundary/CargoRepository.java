package br.com.imerljak.usuarios.boundary;

import br.com.imerljak.usuarios.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, String> {}
