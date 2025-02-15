package com.seek.dao.mapper;


import com.seek.dao.entity.CustomerEntity;
import com.seek.models.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CustomerDaoMapper {

  CustomerEntity toEntity(Customer customer);

  Customer toDto(CustomerEntity customer);

}
