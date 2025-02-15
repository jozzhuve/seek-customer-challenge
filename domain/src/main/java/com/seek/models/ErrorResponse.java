package com.seek.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

  private Integer statusCode;
  private String error;
  private List<String> message;

}
