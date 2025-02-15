package com.seek.config;

import com.seek.ports.out.CustomerRepositoryPort;
import com.seek.security.jwt.JwtUtils;
import com.seek.services.AuthenticatorService;
import com.seek.services.CustomerService;
import com.seek.usecases.AuthenticatorUseCaseImpl;
import com.seek.usecases.CreateCustomerUseCaseImpl;
import com.seek.usecases.RetrieveCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class ApplicationConfig {

  @Bean
  public CustomerService customerService(CustomerRepositoryPort customerRepositoryPort,
                                         SeekConfigurationProperties properties) {
    return new CustomerService(
        new CreateCustomerUseCaseImpl(customerRepositoryPort),
        new RetrieveCustomerUseCaseImpl(customerRepositoryPort, properties)
    );
  }

  @Bean
  public AuthenticatorService authenticateService(AuthenticationManager authenticationManager,
                                                  JwtUtils jwtUtils) {
    return new AuthenticatorService(
        new AuthenticatorUseCaseImpl(authenticationManager, jwtUtils)
    );
  }

}
