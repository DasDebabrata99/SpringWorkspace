package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.entity.Customer;
import com.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model model) {

		List<Customer> customers = customerService.getCustomerList();

		model.addAttribute("customerList", customers);

		return "customer-list";
	}

	@GetMapping("showFormForAdd")
	public String  showFormForAdd(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";

	}

	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
	
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			Model theModel	) {
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
		
	}
	
	@GetMapping("delete")
	public String deleteCustomer(@RequestParam("customerId")int theCustomerId) {
		
		customerService.deleteCustomer(theCustomerId);
		return "redirect:/customer/list";
	}
	
}