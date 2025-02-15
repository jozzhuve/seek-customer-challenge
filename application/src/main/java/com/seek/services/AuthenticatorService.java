package com.seek.services;

import com.seek.models.Jwt;
import com.seek.ports.in.AuthenticatorUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticatorService implements AuthenticatorUseCase {

  private final AuthenticatorUseCase authenticatorUseCase;

  @Override
  public Jwt retrieveToken(String user, String password) {
    return authenticatorUseCase.retrieveToken(user, password);
  }
}
