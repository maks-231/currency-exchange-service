package com.in28.microservices.currency_exchange_service.dto;

import java.math.BigDecimal;

public class CurrencyConversionDto {
  private Long id;

  public BigDecimal getQuantity() {
    return quantity;
  }

  public BigDecimal getTotalCalculateAmount() {
    return totalCalculateAmount;
  }

  private String from;
  private String to;
  private BigDecimal conversionMultiple;
  private BigDecimal quantity;
  private BigDecimal totalCalculateAmount;
  private String environment;

  public CurrencyConversionDto(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal totalCalculateAmount, String environment) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
    this.quantity = quantity;
    this.totalCalculateAmount = totalCalculateAmount;
    this.environment = environment;
  }

  public CurrencyConversionDto() {
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

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public void setTotalCalculateAmount(BigDecimal totalCalculateAmount) {
    this.totalCalculateAmount = totalCalculateAmount;
  }
}
