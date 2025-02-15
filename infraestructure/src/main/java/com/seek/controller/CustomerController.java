package com.seek.controller;

import com.seek.controller.mapper.CustomerControllerMapper;
import com.seek.models.CustomerRequest;
import com.seek.models.CustomerResponse;
import com.seek.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class CustomerController {

  private final CustomerService service;
  private final CustomerControllerMapper mapper;

  @Operation(summary = "Registro de clientes")
  @ApiResponse(responseCode = "200",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
  @PostMapping("/customer")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
    return ResponseEntity.ok(mapper.toResponse(service.create(mapper.toDomain(request))));
  }

  @Operation(summary = "Obtener promedio de edades y desviacion estandar de edades")
  @ApiResponse(responseCode = "200",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
  @GetMapping("/customer/metrics")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<CustomerResponse> getAverageAgeAndStandardDeviationAges() {
    return ResponseEntity.ok(mapper.toResponse(service.getAverageAgeAndStandardDeviationAges()));
  }

  @Operation(summary = "Obtener promedio de edades y desviacion estandar de edades")
  @ApiResponse(responseCode = "200",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
  @GetMapping("/customer/life-expectancy")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<CustomerResponse> getAllCustomersAndLifeExpectancy() {
    return ResponseEntity.ok(mapper.toResponse(service.getAllCustomersAndLifeExpectancy()));
  }
}
