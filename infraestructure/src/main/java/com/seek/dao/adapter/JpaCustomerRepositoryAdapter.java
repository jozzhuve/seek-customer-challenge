package com.seek.dao.adapter;

import com.seek.dao.mapper.CustomerDaoMapper;
import com.seek.dao.repository.JpaCustomerRepository;
import com.seek.models.Customer;
import com.seek.ports.out.CustomerRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class JpaCustomerRepositoryAdapter implements CustomerRepositoryPort {

  protected final JpaCustomerRepository repository;
  protected final CustomerDaoMapper mapper;

  @Override
  public Customer save(Customer customer) {
    return mapper.toDto(repository.save(mapper.toEntity(customer)));
  }

  @Override
  public List<Customer> findAll() {
    ArrayList<Customer> customers = new ArrayList<>();
    repository.findAll().forEach(customerEntity -> {
      customers.add(mapper.toDto(customerEntity));
    });
    return customers;
  }
}
