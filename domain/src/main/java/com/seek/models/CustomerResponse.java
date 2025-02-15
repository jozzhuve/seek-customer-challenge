package com.seek.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {

  private Integer id;
  private String nombre;
  private String apellido;
  private Integer edad;
  private Date fechaNacimiento;
  private Double promedioEdad;
  private Double desviacionEstandarEdad;
  private Double esperanzaVida;
  private List<CustomerResponse> customers;

}
