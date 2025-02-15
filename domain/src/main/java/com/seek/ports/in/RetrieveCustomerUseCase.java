package com.seek.ports.in;

import com.seek.models.Customer;

import java.util.List;

public interface RetrieveCustomerUseCase {
  Customer getAverageAgeAndStandardDeviationAges();
  Customer getAllCustomersAndLifeExpectancy();
}
