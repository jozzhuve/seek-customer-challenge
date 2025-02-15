package com.seek.dao.repository;

import com.seek.dao.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomerRepository extends CrudRepository<CustomerEntity, Integer> {

}
