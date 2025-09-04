package br.com.fiap.soat7.vendas.sales.infrastructure.repository;

import br.com.fiap.soat7.vendas.sales.domain.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}
