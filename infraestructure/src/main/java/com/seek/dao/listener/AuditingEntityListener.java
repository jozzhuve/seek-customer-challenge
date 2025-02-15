package com.seek.dao.listener;

import com.seek.dao.entity.CustomerEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

import java.time.ZoneId;
import java.util.Date;


public class AuditingEntityListener {

  @PrePersist
  public void onPrePersist(CustomerEntity customer) {
    customer.setUserCreation(customer.getNombre());
    customer.setCreationDate(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
  }

  @PreUpdate
  public void onPreUpdate(CustomerEntity customer) {
    customer.setUserUpdate(customer.getNombre());
    customer.setUpdateDate(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
  }

  @PreRemove
  public void onPreRemove(CustomerEntity customer) {
  }


}
