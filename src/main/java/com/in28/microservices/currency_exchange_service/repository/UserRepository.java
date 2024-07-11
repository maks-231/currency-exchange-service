package com.in28.microservices.currency_exchange_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28.microservices.currency_exchange_service.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
