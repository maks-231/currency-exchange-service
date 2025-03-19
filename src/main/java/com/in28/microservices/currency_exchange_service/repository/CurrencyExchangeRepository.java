package com.in28.microservices.currency_exchange_service.repository;

import com.in28.microservices.currency_exchange_service.entity.ExchangeValueEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValueEntity, Long>,
                                                    JpaSpecificationExecutor<ExchangeValueEntity> {
  List<ExchangeValueEntity> findByFromAndTo(String from, String to);
  List<ExchangeValueEntity> findAllByTradedGreaterThanEqual(BigDecimal traded);
}
