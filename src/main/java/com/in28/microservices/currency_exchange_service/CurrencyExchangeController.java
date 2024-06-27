package com.in28.microservices.currency_exchange_service;

import entity.ExchangeValue;

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
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    int port = Integer.valueOf(env.getProperty("server.port"));
    ExchangeValue ev =  new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
    ev.setPort(port);
    return ev;
  }
}
