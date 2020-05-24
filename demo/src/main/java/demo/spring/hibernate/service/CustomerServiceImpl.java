package demo.spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.spring.hibernate.dao.CustomerDAO;
import demo.spring.hibernate.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO dao;
	
	@Transactional
	public List<Customer> addCustomer(Customer c) {
		return dao.addCustomer(c);
	}

	@Transactional
	public List<Customer> getCustomer(long phone) {

		return dao.getCustomerByPhone(phone);
	}

	@Transactional
	public List<Customer> updateCustomer(String name,long phone, Customer c) {
		return dao.updateCustomer(name, phone, c);
	}

	@Transactional
	public List<Customer> searchCustomerByName(String name) {
		return dao.getCustomerByName(name);
	}

	@Transactional
	public List<Customer> searchCustomerByPhone(long phone) {
		
		return dao.getCustomerByPhone(phone);
	}

	@Transactional
	public String BlackListCustomer(long phone) {
		return null;
	}

	@Transactional
	public List<Customer> getAllCustomer() {
		return dao.list();
	}

	@Transactional
	public void deleteCustomer(long phone) {
		dao.deleteCustomer(phone);
	}
	
}
