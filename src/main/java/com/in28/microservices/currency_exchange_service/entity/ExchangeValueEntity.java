package com.in28.microservices.currency_exchange_service.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "exchange_value")
public class ExchangeValueEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(name="customer_id")
  private Long customerId;

  @Column(name = "currency_from")
  private String from;

  @Column(name = "currency_to")
  private String to;

  @Column(name="traded")
  private BigDecimal traded;

  @Column(name="gained")
  private BigDecimal gained;

  @Column(name="trade_date")
  private LocalDate tradeDate;

  public ExchangeValueEntity() {
  }

  public ExchangeValueEntity(Long id, Long customerId, BigDecimal traded, LocalDate tradeDate, BigDecimal gained, String from, String to) {
    this.id = id;
    this.customerId = customerId;
    this.traded = traded;
    this.tradeDate = tradeDate;
    this.gained = gained;
    this.from = from;
    this.to = to;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
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
}
