package com.seek.ports.in;


import com.seek.models.Customer;

public interface CreateCustomerUseCase {
    Customer create(Customer customer);
}
