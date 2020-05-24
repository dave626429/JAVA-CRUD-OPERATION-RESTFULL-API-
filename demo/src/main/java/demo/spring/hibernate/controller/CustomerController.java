package demo.spring.hibernate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import demo.spring.hibernate.entity.Customer;
import demo.spring.hibernate.service.CustomerService;

@Controller
@RequestMapping
public class CustomerController {

	@Autowired
	private CustomerService cs;

	//    Working
	//  [ EVERY RECORD IN DATABASE ]
	@GetMapping("/all")
	public ModelAndView getAllCustomers() {

		List<Customer> list = (List<Customer>) cs.getAllCustomer();

		ModelAndView model = new ModelAndView();
		model.setViewName("customer");
		model.addObject("list", list);
		
		return model;
	}
	
	
	//    Working
	@GetMapping("/add")
	public ModelAndView addPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("addcustomer");
		return model;
	}
	

	//    Working
	//  [ DELETE RECORD FROM DATABASE ON PHONE ]
	@GetMapping("/delete")
	public String deleteCustomer(@ModelAttribute(name="phone") String phone) {
		
		if(phone!=null)
			cs.deleteCustomer((long)Long.parseLong(phone));
		
		return "redirect:/all";
	}

	//    Working
	//  [ INSERT RECORD INTO DATABASE ]
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestParam(required=false,name="name") String name, @RequestParam(required=false,name="service") String service,
			@RequestParam(required=false,name="phone") String phone, @RequestParam(required=false,name="date") String date) {
		
		Customer c = new Customer();
		if(date!=null)
			c.setDate(date);
		if(name!=null)
			c.setName(name);
		if(phone!=null)
			c.setPhone((long)Long.parseLong(phone));
		if(service!=null)
			c.setServices(service);
		
		return "redirect:/all";

	}
//-----------------------------------------------------------------------------------------------------------------------------------
	
	public ModelAndView searchCustomerByPhone() {
		return null;
	}
	public ModelAndView searchCustomerByName() {
		return null;
	}
	public void updateCustomer() {
		
	}


}
