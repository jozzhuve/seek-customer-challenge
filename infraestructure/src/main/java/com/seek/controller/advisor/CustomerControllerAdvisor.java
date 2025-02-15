package com.seek.controller.advisor;

import com.seek.models.ErrorResponse;
import com.seek.models.exception.CustomerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
public class CustomerControllerAdvisor {

  @ExceptionHandler({CustomerException.class})
  @ResponseBody
  public ResponseEntity<ErrorResponse> handleBCustomerException(CustomerException ex) {
    ErrorResponse er = new ErrorResponse(
        ex.getStatusCode(),
        ex.getError(),
        Stream.of(ex.getMessage()).collect(Collectors.toList()));
    return ResponseEntity.badRequest().body(er);
  }

  @ExceptionHandler({MethodArgumentNotValidException.class})
  @ResponseBody
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();
    List<String> messages = new ArrayList<>();
    for (FieldError error : fieldErrors) {
      messages.add(error.getDefaultMessage() + " '" + error.getField() + "'");
    }
    ErrorResponse er = new ErrorResponse(
        ex.getStatusCode().value(),
        BAD_REQUEST.getReasonPhrase(),
        messages);
    return ResponseEntity.badRequest().body(er);
  }

  @ExceptionHandler({Exception.class})
  @ResponseBody
  public ResponseEntity<ErrorResponse> handleException(Exception ex) {
    ErrorResponse er = new ErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        "Ocurrio un error inesperado",
        Stream.of(ex.getMessage()).collect(Collectors.toList()));
    return ResponseEntity.badRequest().body(er);
  }
}

