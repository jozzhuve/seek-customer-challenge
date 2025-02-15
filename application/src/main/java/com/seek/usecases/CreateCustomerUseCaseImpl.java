package com.seek.usecases;

import com.seek.models.Customer;
import com.seek.ports.in.CreateCustomerUseCase;
import com.seek.ports.out.CustomerRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

  protected final CustomerRepositoryPort customerRepositoryPort;

  @Override
  public Customer create(Customer customer) {
    return customerRepositoryPort.save(customer);
  }
}
