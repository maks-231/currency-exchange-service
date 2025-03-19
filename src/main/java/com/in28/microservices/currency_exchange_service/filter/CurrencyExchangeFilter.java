package com.in28.microservices.currency_exchange_service.filter;

import com.in28.microservices.currency_exchange_service.entity.ExchangeValueEntity;
import com.in28.microservices.currency_exchange_service.entity.ExchangeValueEntity_;

import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class CurrencyExchangeFilter {
  public static Specification<ExchangeValueEntity> isLongTermCustomer() {
    return (root, query, builder) -> {
      LocalDate date = LocalDate.now().minusYears(2);
      return builder.lessThan(root.get(ExchangeValueEntity_.tradeDate), date);
    };
  }
}
