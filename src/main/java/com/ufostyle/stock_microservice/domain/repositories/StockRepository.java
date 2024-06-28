package com.ufostyle.stock_microservice.domain.repositories;

import com.ufostyle.stock_microservice.domain.entities.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

    Optional<StockEntity> findByCode(String code);
}
