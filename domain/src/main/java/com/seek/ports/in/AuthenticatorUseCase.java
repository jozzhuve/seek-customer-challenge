package com.seek.ports.in;

import com.seek.models.Jwt;

public interface AuthenticatorUseCase {
  Jwt retrieveToken(String user, String password);
}

