package com.seek.services;

import com.seek.models.Customer;
import com.seek.ports.in.CreateCustomerUseCase;
import com.seek.ports.in.RetrieveCustomerUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerService implements CreateCustomerUseCase,
    RetrieveCustomerUseCase {

  protected final CreateCustomerUseCase createCustomerUseCase;
  protected final RetrieveCustomerUseCase retrieveCustomerUseCase;

  @Override
  public Customer create(Customer customer) {
    return createCustomerUseCase.create(customer);
  }

  @Override
  public Customer getAverageAgeAndStandardDeviationAges() {
    return retrieveCustomerUseCase.getAverageAgeAndStandardDeviationAges();
  }

  @Override
  public Customer getAllCustomersAndLifeExpectancy() {
    return retrieveCustomerUseCase.getAllCustomersAndLifeExpectancy();
  }
}
