package com.in28.microservices.currency_exchange_service.configuration;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
  @Bean
  public SecurityFilterChain filterChaim(HttpSecurity http) {
    try {
//      http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//      http.httpBasic(Customizer.withDefaults());
      return http.build();
    } catch (Exception e) {
      throw new RuntimeException("Cannot create a security chain");
    }
  }
}
