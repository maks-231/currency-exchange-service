package com.in28.microservices.currency_exchange_service.dto;

import java.math.BigDecimal;

public class CurrencyExchangeDto {
  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionMultiple;

  private String environment;

  public CurrencyExchangeDto() {
  }

  public CurrencyExchangeDto(Long id, String from, String to, BigDecimal conversionMultiple) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
  }

  public Long getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public String getEnvironment() {
    return environment;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public void setConversionMultiple(BigDecimal conversionMultiple) {
    this.conversionMultiple = conversionMultiple;
  }
}
