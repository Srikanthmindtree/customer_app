package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	public List<Customer> getAll(){
		return repository.findAll();
	}
		
		public Customer getById(long id) {
		Optional<Customer> customer = repository.findById(id);
		if(customer.isEmpty())
			throw new CustomerNotFoundException("No customer is present for this id"+id);
		return customer.get();
		}
		public Customer save(Customer customer)
		{
			Customer uni = repository.save(customer);
			return uni;
		}
	
}
