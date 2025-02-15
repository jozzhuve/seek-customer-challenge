package com.seek.usecases;

import com.seek.config.CustomerApiProperties;
import com.seek.config.SeekConfigurationProperties;
import com.seek.models.Customer;
import com.seek.ports.out.CustomerRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RetrieveCustomerUseCaseImplTest {

  public static final int AGE = 33;
  @InjectMocks
  private RetrieveCustomerUseCaseImpl retrieveCustomerUseCase;
  @Mock
  private CustomerRepositoryPort customerRepositoryPort;

  @BeforeEach
  void setUp() {
    SeekConfigurationProperties properties = new SeekConfigurationProperties();
    CustomerApiProperties candidateApiProperties = new CustomerApiProperties();
    candidateApiProperties.setEdadesMortalidadPeru(Stream.of(67,78,43,67).collect(Collectors.toList()));
    properties.setCustomer(candidateApiProperties);
    retrieveCustomerUseCase = new RetrieveCustomerUseCaseImpl(customerRepositoryPort, properties);
  }

  @Test
  void getAllCustomer_when_customerExists() {
    when(customerRepositoryPort.findAll())
        .thenReturn(Stream.of(buildCustomer()).collect(Collectors.toList()));
    Customer test = retrieveCustomerUseCase.getAllCustomersAndLifeExpectancy();
    assertThat(test.getCustomers().size()).isEqualTo(1);
  }

  private Customer buildCustomer() {
    Customer customer = new Customer();
    customer.setId(1);
    customer.setNombre("jose");
    customer.setEdad(AGE);
    return customer;
  }

}
