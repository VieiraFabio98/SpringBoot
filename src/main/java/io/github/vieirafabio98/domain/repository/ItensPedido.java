package io.github.vieirafabio98.domain.repository;

import io.github.vieirafabio98.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
