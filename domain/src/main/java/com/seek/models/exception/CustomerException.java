package com.seek.models.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerException extends RuntimeException {

  private Integer statusCode;
  private String error;
  private String message;

}
