package com.in28.microservices.currency_exchange_service.controller;

import com.in28.microservices.currency_exchange_service.model.CurrencyConversion;
import com.in28.microservices.currency_exchange_service.model.CurrencyExchange;
import com.in28.microservices.currency_exchange_service.service.CurrencyExchangeProxy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import jakarta.annotation.Resource;


@RestController
public class CurrencyConversionController {
  @Resource
  private CurrencyExchangeProxy currencyExchangeProxy;

  @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
                                                        @PathVariable BigDecimal quantity) {

    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);

    ResponseEntity<CurrencyExchange> responseEntity = new RestTemplate().getForEntity("http://currency-exchange-service/currency-exchange/from/{from}/to/{to}",
                                                                                      CurrencyExchange.class, uriVariables);
    CurrencyExchange cc = responseEntity.getBody();
    return new CurrencyConversion(cc.getId(), from, to, cc.getConversionMultiple(),  quantity, cc.getConversionMultiple().multiply(quantity), cc.getEnvironment());

  }

  @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
                                                        @PathVariable BigDecimal quantity) {

    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);

    CurrencyExchange cc = currencyExchangeProxy.retrieveExchangeValue(from, to);
    return new CurrencyConversion(cc.getId(), from, to, cc.getConversionMultiple(),  quantity, cc.getConversionMultiple().multiply(quantity), cc.getEnvironment() + " " + "feign");

  }
}
