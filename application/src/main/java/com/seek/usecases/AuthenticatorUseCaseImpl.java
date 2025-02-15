package com.seek.usecases;


import com.seek.models.Jwt;
import com.seek.ports.in.AuthenticatorUseCase;
import com.seek.security.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@AllArgsConstructor
public class AuthenticatorUseCaseImpl implements AuthenticatorUseCase {

  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;

  @Override
  public Jwt retrieveToken(String user, String password) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(user, password));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    return Jwt.builder()
        .token(jwt)
        .build();
  }
}
