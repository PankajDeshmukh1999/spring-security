package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.VO.ResponseTemplateVO;
import com.customer.entity.Customer;
import com.customer.entity.Product;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
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

	public ResponseTemplateVO getCustomerWithProduct(int cId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Customer customer  = repository.getById(cId);
		Product product = restTemplate.getForObject("http://localhost:8001/product/"+ customer.getcId(),
				Product.class);
		vo.setCustomer(customer);
		vo.setProduct(product);
		return vo;
	}
}
