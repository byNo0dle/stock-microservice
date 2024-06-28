package com.ufostyle.stock_microservice.infrastructure.controllers;

import com.ufostyle.stock_microservice.domain.entities.StockEntity;
import com.ufostyle.stock_microservice.domain.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    public boolean stockAvailable(@PathVariable String code) {
        Optional<StockEntity> stock = stockRepository.findByCode(code);
        stock.orElseThrow(() -> new RuntimeException("Cannot find the product " + code));

        return stock.get().getQuantity() > 0;
    }
}
