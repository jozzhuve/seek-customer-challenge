package com.seek.security.jwt;

import com.google.gson.Gson;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Slf4j
@AllArgsConstructor
@Component
public class JwtUtils {

  public String generateJwtToken(Authentication authentication) {

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    return Jwts.builder()
        .setSubject(new Gson().toJson(userDetails.getUsername()))
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + 8640000))
        .signWith(key(), SignatureAlgorithm.HS256)
        .compact();
  }

  private Key key() {
    return Keys.hmacShaKeyFor(
        // El valor del secret deberia ir en un archivo de propiedades
        Decoders.BASE64.decode("OHBTc2dwTjIwMjM9OHBTc2dwTjIwMjM9OHBTc2dwTjIwMjM9OHBTc2dwTjIwMjM9OHBTc2dwTjIwMjM="));
  }

  public String getUserNameFromJwtToken(String token) {
    return new Gson().fromJson(Jwts.parserBuilder().setSigningKey(key()).build()
        .parseClaimsJws(token).getBody().getSubject(), String.class);
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    } catch (MalformedJwtException e) {
      log.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      log.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      log.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      log.error("JWT claims string is empty: {}", e.getMessage());
    }
    return false;
  }
}
