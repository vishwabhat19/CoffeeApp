package com.coffee.repository;

import org.springframework.data.repository.CrudRepository;

import com.coffee.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
