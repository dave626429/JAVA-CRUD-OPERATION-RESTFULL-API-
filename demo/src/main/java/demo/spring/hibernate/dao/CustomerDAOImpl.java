package demo.spring.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.spring.hibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sf;

	public List<Customer> list() {
		Session s = sf.getCurrentSession();
		Query<Customer> q = s.createQuery("from Customer");
		List<Customer> list = q.getResultList();
		return list;
	}
	public List<Customer> getCustomerByName(String name) {
		Session s = sf.getCurrentSession();
		Query<Customer> q = s.createQuery("from Customer where name=:n");
		q.setParameter("n", name);
		List<Customer> list = q.list();
		return list;
	}
	
	public List<Customer> getCustomerByPhone(long phone) {
		Session s = sf.getCurrentSession();
		Query<Customer> q = s.createQuery("from Customer where phone=:p");
		q.setParameter("p", phone);
		List<Customer> list = q.list();
		return list;
	}

	public void deleteCustomer(long phone) {
		Session s = sf.getCurrentSession();
		Query<Customer> q = s.createQuery("delete Customer where phone=:p");
		q.setParameter("p", phone);
		q.executeUpdate();
	}

	public List<Customer> updateCustomer(String name, long phone, Customer c) {
		Session s = sf.getCurrentSession();
		Query<Customer> q = s.createQuery("update Customer set name=:n,service=:s,phone=:ph where phone=:p");
		q.setParameter("p", phone);
		q.setParameter("ph", c.getPhone());
		q.setParameter("n", c.getName());
		q.setParameter("s", c.getServices());
		q.executeUpdate();
		List<Customer> list = getCustomerByPhone(c.getPhone());
		return list;
	}

	public List<Customer> addCustomer(Customer c) {
		Session s=sf.getCurrentSession();
		s.save(c);
		return getCustomerByPhone(c.getPhone());
	}

}
