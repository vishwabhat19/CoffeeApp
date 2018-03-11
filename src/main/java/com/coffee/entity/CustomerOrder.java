package com.coffee.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	private Double total;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinTable(name="ORDER_PRODUCTS",joinColumns={@JoinColumn(name="ORDER_ID")},inverseJoinColumns={@JoinColumn(name="PRODUCT_ID")})
	private Set<Product> products;
	
	@OneToOne
	private Customer customer;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
