package com.seek.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Customer {

  private Integer id;
  private String nombre;
  private String apellido;
  private Integer edad;
  private Date fechaNacimiento;
  private Double promedioEdad;
  private Double desviacionEstandarEdad;
  private Double esperanzaVida;
  private List<Customer> customers;

}
