package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	public void saveData(Customer customer) {
		repository.save(customer);
	}

	public void saveAllData(List<Customer> customer) {
		repository.saveAll(customer);
	}

	public Optional<Customer> getDataById(int cId) {
		return repository.findById(cId);
	}

	public List<Customer> getAllData() {
		return (List<Customer>) repository.findAll();
	}

	public void updateData(int cId, Customer customer) {
		repository.save(customer);
	}

	public void deleteDataById(int cId) {
		repository.deleteById(cId);
	}

	public void deleteAllData() {
		repository.deleteAll();
	}
}
