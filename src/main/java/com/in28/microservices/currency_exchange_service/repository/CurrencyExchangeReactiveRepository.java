package com.in28.microservices.currency_exchange_service.repository;

import com.in28.microservices.currency_exchange_service.entity.ExchangeValueEntity;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyExchangeReactiveRepository extends ReactiveCrudRepository<ExchangeValueEntity, Long> {
  List<ExchangeValueEntity> findByFromAndTo(String from, String to);
  List<ExchangeValueEntity> findAllByTradedGreaterThanEqual(BigDecimal traded);
}
