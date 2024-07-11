package com.in28.microservices.currency_exchange_service.controller;

import com.in28.microservices.currency_exchange_service.entity.ExchangeValue;
import com.in28.microservices.currency_exchange_service.model.CurrencyExchange;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
  @Resource
  Environment env;

  @GetMapping("/from/{from}/to/{to}")
  public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    CurrencyExchange ce =  new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(65));
    String port = env.getProperty("server.port");
    ce.setEnvironment(port);
    return ce;
  }

  @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {
    CurrencyExchange ce =  new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(65));
    String port = env.getProperty("server.port");
    ce.setEnvironment(port);
    return ce;
  }
}
