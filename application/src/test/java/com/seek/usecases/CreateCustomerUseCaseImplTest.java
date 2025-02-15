package com.seek.usecases;

import com.seek.models.Customer;
import com.seek.models.exception.CustomerException;
import com.seek.ports.out.CustomerRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCustomerUseCaseImplTest {

  public static final int AGE = 33;
  @InjectMocks
  private CreateCustomerUseCaseImpl createCandidateUseCase;
  @Mock
  private CustomerRepositoryPort customerRepositoryPort;

  @BeforeEach
  void setUp() {
    createCandidateUseCase = new CreateCustomerUseCaseImpl(customerRepositoryPort);
  }

  @Test
  void registerCandidate_when_candidateIsAdult() {
    when(customerRepositoryPort.save(any()))
        .thenReturn(buildCandidate(AGE));
    Customer test = createCandidateUseCase.create(buildCandidate(33));
    assertThat(test.getEdad()).isEqualTo(33);
  }

  private Customer buildCandidate(int edad) {
    Customer customer = new Customer();
    customer.setId(1);
    customer.setNombre("jose");
    customer.setEdad(edad);
    return customer;
  }

}
