package com.in28.microservices.currency_exchange_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
  private Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);
  @GetMapping("/sample-api")
  @Bulkhead(name = "sample-api", fallbackMethod = "hardcodedResponse")
  public String sampleApi() {
    log.info("Sample Api call received!");
    ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
    return responseEntity.getBody();
  }

  public String hardcodedResponse(Exception e) {
    return "fallback response";
  }
}
