package com.in28.microservices.currency_exchange_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(name="first_name")
  @Size(min = 2, message = "Name should be at least 2 characters")
  private String firstName;

  @Column(name="last_name")
  @Size(min = 2, message = "Last name should be at least 2 characters")
  private String lastMame;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastMame() {
    return lastMame;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastMame(String lastMame) {
    this.lastMame = lastMame;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }
}
