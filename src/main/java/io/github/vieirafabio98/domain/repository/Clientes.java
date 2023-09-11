package io.github.vieirafabio98.domain.repository;

import io.github.vieirafabio98.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {
    
    List<Cliente> findByNomeLike(String nome);
}