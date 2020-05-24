package demo.spring.hibernate.service;

import java.util.List;

import demo.spring.hibernate.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomer(); 
	public List<Customer> addCustomer(Customer c);
	public List<Customer> getCustomer(long phone);
	public List<Customer> updateCustomer(String name,long phone, Customer c);
	public List<Customer> searchCustomerByName(String name);
	public List<Customer> searchCustomerByPhone(long phone);
	public String BlackListCustomer(long phone);
	public void deleteCustomer(long phone);
}
