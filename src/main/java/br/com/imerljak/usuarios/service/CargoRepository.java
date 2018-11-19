package br.com.imerljak.usuarios.service;

import br.com.imerljak.usuarios.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, String> {}
