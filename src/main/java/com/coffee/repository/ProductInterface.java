package com.coffee.repository;

import org.springframework.data.repository.CrudRepository;

import com.coffee.entity.Product;

public interface ProductInterface extends CrudRepository<Product, Long> {

}
