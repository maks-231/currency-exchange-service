package com.in28.microservices.currency_exchange_service.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExchangeValue {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(name = "currency_from")
  private String from;

  @Column(name = "currency_to")
  private String to;

  @Column(name = "conversion_multiple")
  private BigDecimal conversionMultiple;

  @Column(name="port")
  private int port;

  public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
  }

  public ExchangeValue() {
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
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
