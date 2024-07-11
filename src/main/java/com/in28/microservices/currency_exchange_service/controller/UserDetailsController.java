package com.in28.microservices.currency_exchange_service.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28.microservices.currency_exchange_service.entity.User;
import jakarta.annotation.Resource;
import com.in28.microservices.currency_exchange_service.repository.UserRepository;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserDetailsController {
  @Resource
  UserRepository userRepository;

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public EntityModel<User> getUserById(@PathVariable Long id) throws Exception {
    Optional<User> userOptional = userRepository.findById(id);

    if(userOptional.isEmpty()) {
      throw new Exception("User not found");
    }
    User user = userOptional.get();
    EntityModel entityModel = EntityModel.of(user);
    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
    entityModel.add(link.withRel("users"));
    return entityModel;
  }
}
