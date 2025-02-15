package com.seek.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
@Slf4j
public class SeekAuthenticationProvider implements AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    final String name = authentication.getName();
    final String password = authentication.getCredentials().toString();

    // La logica de credenciales deberia ir a una base de datos o a un provedor tercero para garantizar la seguridad
    if (!"jhurtado".equals(name) || !"$e3K2024".equals(password)) {
      throw new AuthenticationCredentialsNotFoundException("Usuario y/o contraseña invalida");
    }

    return authenticateAgainstThirdPartyAndGetAuthenticationMock(name, password);
  }

  private static UsernamePasswordAuthenticationToken authenticateAgainstThirdPartyAndGetAuthenticationMock(String name, String password) {
    final List<GrantedAuthority> grantedAuths = new ArrayList<>();
    grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    final UserDetails principal = new User(name, password, grantedAuths);
    return new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
  }

  @Override
  public boolean supports(Class<?> auth) {
    return auth.equals(UsernamePasswordAuthenticationToken.class);
  }
}
