package com.coffee.repository;

import org.springframework.data.repository.CrudRepository;

import com.coffee.entity.CustomerOrder;

public interface OrderRepository extends CrudRepository<CustomerOrder,Long> {

}
