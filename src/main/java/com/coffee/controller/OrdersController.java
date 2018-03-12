package com.coffee.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.entity.Customer;
import com.coffee.entity.CustomerOrder;
import com.coffee.entity.Product;
import com.coffee.repository.CustomerRepository;
import com.coffee.repository.OrderRepository;
import com.coffee.repository.ProductRepository;

@Controller
public class OrdersController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@RequestMapping(value="/orders",method=RequestMethod.GET)
	public String productsList(Model model){
		model.addAttribute("products",productRepository.findAll());
		model.addAttribute("orders", orderRepository.findAll());
		return "orders";
		
	}
	
	@RequestMapping(value="/createOrder",method=RequestMethod.POST)
	@ResponseBody
	public String saveOrder(@RequestParam String firstName,@RequestParam String lastName,@RequestParam(value="productIds[]")Long[] productIds){
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customerRepository.save(customer);
		CustomerOrder customerOrder = new CustomerOrder();
		Optional<Customer> optional = customerRepository.findById(customer.getCustomerId());
		if(optional.isPresent()){
			customerOrder.setCustomer(optional.get());
		}
		Set<Product> productSet = new HashSet<>();
		for(Long productId : productIds){
			Optional<Product> product = productRepository.findById(productId);
			if(optional.isPresent()){
				productSet.add(product.get());
			}
		}
		customerOrder.setProducts(productSet);
		Double total = 0.0;
		
		for(Long productId:productIds){
			Optional<Product> product = productRepository.findById(productId);
			if(product.isPresent()){
				total = total + (product.get().getProductPrice());
			}
			
		}
		customerOrder.setTotal(total);
		orderRepository.save(customerOrder);
		return customerOrder.getOrderId().toString();
	}
	
	@RequestMapping(value="/removeOrder",method = RequestMethod.POST)
	@ResponseBody
	public String removeOrder(@RequestParam Long id){
		orderRepository.deleteById(id);
		return id.toString();
	}
}
