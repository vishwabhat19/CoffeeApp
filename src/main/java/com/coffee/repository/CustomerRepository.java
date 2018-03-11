package com.coffee.repository;

import org.springframework.data.repository.CrudRepository;

import com.coffee.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
