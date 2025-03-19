package com.in28.microservices.currency_exchange_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeValueDto {
  private Long id;
  private String from;
  private String to;

  private Long customerId;

  private BigDecimal traded;

  private BigDecimal gained;

  private LocalDate tradeDate;

  public ExchangeValueDto() {
  }

  public ExchangeValueDto(Long id) {
    this.id = id;
  }

  public ExchangeValueDto(Long id, String from, String to, Long customerId, BigDecimal traded, LocalDate tradeDate, BigDecimal gained) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.customerId = customerId;
    this.traded = traded;
    this.tradeDate = tradeDate;
    this.gained = gained;
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

  public void setId(Long id) {
    this.id = id;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long userId) {
    this.customerId = userId;
  }

  public BigDecimal getTraded() {
    return traded;
  }

  public void setTraded(BigDecimal traded) {
    this.traded = traded;
  }

  public BigDecimal getGained() {
    return gained;
  }

  public void setGained(BigDecimal gained) {
    this.gained = gained;
  }

  public LocalDate getTradeDate() {
    return tradeDate;
  }

  public void setTradeDate(LocalDate tradeDate) {
    this.tradeDate = tradeDate;
  }
}
