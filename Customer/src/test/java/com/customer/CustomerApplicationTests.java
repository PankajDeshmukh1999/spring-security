package com.customer;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.netflix.discovery.converters.Auto;

@SpringBootTest
class CustomerApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	@Autowired
//	private CustomerRepository repository;
	

//	
//	@Test
//	public void testReadAll () {
//		List list = repository.findAll();
//		assertThat(list).size().isGreaterThan(0);
//	}
	
//	@Test
//	public void testCreate () {
//		Customer p = new Customer();
//		p.setcId(88);
//		p.setName("vekatesh");
//		p.setContact("9876543210");
//		repository.save(p);
//		assertNotNull(repository.findById(1).get());
//	}
	
//	@Test
//	public void testRead () {
//		Customer product = repository.findById(1).get();
//		assertEquals("nikhil", product.getName());
//	}
	

}
