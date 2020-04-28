package com.bhozida.backend.config.core_service;

import com.bhozida.backend.config.core_model.User;
import com.bhozida.backend.config.core_repository.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}