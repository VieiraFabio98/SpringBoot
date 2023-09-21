package io.github.vieirafabio98.domain.repository;

import io.github.vieirafabio98.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
