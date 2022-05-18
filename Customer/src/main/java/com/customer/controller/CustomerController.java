package com.customer.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.VO.ResponseTemplateVO;
import com.customer.entity.Customer;
import com.customer.entity.Product;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@Autowired
	private RestTemplate restTemplate;
	
//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/saveData")
	public ResponseEntity<String> saveData(@RequestBody Customer customer) {
		service.saveData(customer);
		return ResponseEntity.ok("Data Saved");
	}

	
	@PostMapping("/saveAllData")
	public ResponseEntity<String> saveMultipleData(@RequestBody List<Customer> customer) {
		service.saveAllData(customer);
		return ResponseEntity.ok("All data saved");
	}

	
	@GetMapping("/getDataById/{empId}")
	public ResponseEntity<Optional<Customer>> getDataById(@PathVariable("empId") int cId) {
		return ResponseEntity.ok(service.getDataById(cId));
	}

	

	@GetMapping("/getAllData")
	public ResponseEntity<List<Customer>> getAllData() {
		return ResponseEntity.ok(service.getAllData());
	}


	@PutMapping("/updateData/{cId}")
	public ResponseEntity<String> updateData(@RequestBody Customer customer, @PathVariable("cId") int cId) {
		service.updateData(cId, customer);
		return ResponseEntity.ok("Data Updated");
	}

	

	@DeleteMapping("/deleteDataById/{cId}")
	public ResponseEntity<String> deleteDataById(@PathVariable("cId") int cId) {
		service.deleteDataById(cId);
		return ResponseEntity.ok("Data Delete");
	}



	@DeleteMapping("/deleteAllData")
	public ResponseEntity<String> deleteAllData() {
		service.deleteAllData();
		return ResponseEntity.ok("empty");
	}
	
	
//  call another service
	
//	@RequestMapping("/{cId}")
//	public Customer getCustomProduct(@PathVariable("cId") int cId) {
//		Customer customer = new Customer();
//		
//		List products = this.restTemplate.getForObject("http://product-service/product/1" , List.class);
//		
//		customer.setProduct(products);
//		return customer;
//	}
	
	
	@RequestMapping("/{cId}")
	public ResponseTemplateVO getCustomerWithProduct(@PathVariable("cId") int cId) {
		return service.getCustomerWithProduct(cId);
	}

}
