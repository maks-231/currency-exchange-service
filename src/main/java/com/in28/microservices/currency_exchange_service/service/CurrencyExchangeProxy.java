package com.in28.microservices.currency_exchange_service.service;

import com.in28.microservices.currency_exchange_service.model.CurrencyExchange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange-service:8000")
public interface CurrencyExchangeProxy {
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
