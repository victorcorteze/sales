package br.com.fiap.soat7.vendas.sales.infrastructure.repository;

import br.com.fiap.soat7.vendas.sales.domain.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
