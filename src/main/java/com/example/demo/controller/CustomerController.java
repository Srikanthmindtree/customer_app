package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired 
	private CustomerService service;
	@GetMapping("/customers")
	public List<Customer> getAll(){
		return service.getAll();
	}
	@GetMapping("/customers/{id}")
	public Customer getUniversity(@PathVariable(name = "id") long id) {
		return service.getById(id);
	}
	@PostMapping("/customers")
	public Customer saveUniversity(@RequestBody Customer customer)
	{
		return service.save(customer);
	}
	

}
