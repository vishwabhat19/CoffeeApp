package com.coffee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.entity.Product;
import com.coffee.repository.ProductRepository;

@Controller
public class ProductsController {

	
	@Autowired
	ProductRepository productRepository;
	
	
	@RequestMapping("/product/{id}")
	public String product(@PathVariable Long id,Model model){
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()){
			model.addAttribute("product", product.get());
		}
		return "product";
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public String productsList(Model model){
		model.addAttribute("products",productRepository.findAll());
		return "products";
	}
	
	@RequestMapping(value="/saveproduct",method=RequestMethod.POST)
	@ResponseBody
	public String saveProduct(@RequestBody Product product){
		productRepository.save(product);
		return product.getProductId().toString();
	}
}
