package com.seek.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomerRequest {

  private Integer id;
  @NotNull(message = "required property")
  private String nombre;
  @NotNull(message = "required property")
  private String apellido;
  @NotNull(message = "required property")
  private Integer edad;
  @NotNull(message = "required property")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-5")
  private Date fechaNacimiento;

}
