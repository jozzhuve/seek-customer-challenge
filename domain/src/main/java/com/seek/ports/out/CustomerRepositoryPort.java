package com.seek.ports.out;

import com.seek.models.Customer;

import java.util.List;

public interface CustomerRepositoryPort {
  Customer save(Customer customer);
  List<Customer> findAll();
}
