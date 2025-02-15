package com.seek.controller.mapper;

import com.seek.models.Customer;
import com.seek.models.CustomerRequest;
import com.seek.models.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CustomerControllerMapper {

  Customer toDomain(CustomerRequest customerRequest);
  CustomerResponse toResponse(Customer customer);

}
