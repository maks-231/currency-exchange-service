package com.in28.microservices.currency_exchange_service.controller;

import com.in28.microservices.currency_exchange_service.dto.ExchangeValueDto;
import com.in28.microservices.currency_exchange_service.repository.CurrencyExchangeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.math.BigDecimal;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
  @Resource
  Environment env;

  @Resource
  CurrencyExchangeRepository currencyExchangeRepository;

  @GetMapping("/all")
  public List<ExchangeValueDto> currencyExchangeGetAll() {
    ModelMapper mapper = new ModelMapper();

    return currencyExchangeRepository.findAll()
        .stream()
        .map(entity -> mapper.map(entity, ExchangeValueDto.class))
        .toList();
  }

  @GetMapping("/from/{from}/to/{to}")
  public List<ExchangeValueDto> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    ModelMapper mapper = new ModelMapper();
    return currencyExchangeRepository.findByFromAndTo(from, to)
        .stream()
        .map(entity -> mapper.map(entity, ExchangeValueDto.class))
        .toList();
  }
  @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
  public List<ExchangeValueDto> retrieveExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {
    ModelMapper mapper = new ModelMapper();
    return currencyExchangeRepository.findByFromAndTo(from, to)
        .stream().filter(entity -> entity.getTraded().compareTo(BigDecimal.valueOf(quantity)) >= 0)
        .map(entity -> mapper.map(entity, ExchangeValueDto.class))
        .toList();
  }
  @GetMapping("/more-then/{quantity}")
  public List<ExchangeValueDto> retrieveExchangeValue(@PathVariable BigDecimal quantity) {
    ModelMapper mapper = new ModelMapper();
    return currencyExchangeRepository.findAllByTradedGreaterThanEqual(quantity)
        .stream()
        .map(entity -> mapper.map(entity, ExchangeValueDto.class))
        .toList();
  }
}
