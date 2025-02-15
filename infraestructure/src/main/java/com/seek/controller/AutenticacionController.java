package com.seek.controller;

import com.seek.services.AuthenticatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/seguridad")
@AllArgsConstructor
public class AutenticacionController {

  private final AuthenticatorService authenticatorService;

  @Operation(
      summary = "Obtener token",
      responses = {
          @ApiResponse(responseCode = "200", description = "Obtiene un token de jwt")
      }
  )
  @GetMapping("/token")
  public ResponseEntity<?> authenticateIdExterno(@RequestHeader("user") String user,
                                                 @RequestHeader("password") String password) {
    return ResponseEntity.ok(authenticatorService.retrieveToken(user, password));
  }
}
