package com.seek.controller;

import com.seek.controller.mapper.CustomerControllerMapper;
import com.seek.models.Customer;
import com.seek.models.CustomerRequest;
import com.seek.models.CustomerResponse;
import com.seek.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CustomerControllerTest {

  public static final int AGE = 33;
  @InjectMocks
  private CustomerController controller;
  @Mock
  private CustomerService service;
  @Mock
  private CustomerControllerMapper mapper;

  @BeforeEach
  void setUp() {
    controller = new CustomerController(service, mapper);
  }

  @Test
  void newCutomer() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    when(service.create(any())).thenReturn(buildCutomer());
    when(mapper.toDomain(any())).thenReturn(buildCutomer());
    when(mapper.toResponse(any())).thenReturn(buildResponse());
    ResponseEntity<CustomerResponse> test = controller.create(buildRequest());
    assertThat(test.getBody().getEdad()).isEqualTo(AGE);
  }

  private List<Customer> buildCutomerList() {
    return Stream.of(buildCutomer()).collect(Collectors.toList());
  }

  private Customer buildCutomer() {
    Customer customer = new Customer();
    customer.setId(1);
    customer.setNombre("jose");
    customer.setEdad(AGE);
    return customer;
  }

  private CustomerRequest buildRequest() {
    CustomerRequest customerRequest = new CustomerRequest();
    customerRequest.setId(1);
    customerRequest.setNombre("Gonzalo");
    customerRequest.setApellido("Perez");
    customerRequest.setEdad(AGE);
    customerRequest.setFechaNacimiento(new Date());
    return customerRequest;
  }

  private CustomerResponse buildResponse() {
    return CustomerResponse.builder()
        .id(1)
        .nombre("Gonzalo")
        .apellido("Perez")
        .edad(AGE)
        .fechaNacimiento(new Date())
        .build();
  }

}
