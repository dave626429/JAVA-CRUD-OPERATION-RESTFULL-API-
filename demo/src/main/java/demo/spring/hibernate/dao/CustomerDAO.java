package demo.spring.hibernate.dao;

import java.util.List;

import demo.spring.hibernate.entity.Customer;

public interface CustomerDAO {

	public List<Customer> list();
	public List<Customer> getCustomerByName(String name);
	public List<Customer> getCustomerByPhone(long phone);
	public void deleteCustomer(long phone);
	public List<Customer> updateCustomer(String name, long phone, Customer c);
	public List<Customer> addCustomer(Customer c);
}
