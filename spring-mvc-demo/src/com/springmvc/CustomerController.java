package com.springmvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
		
	}
	
	@RequestMapping("/processForm")
	public String onSubmit(@Valid @ModelAttribute("customer")Customer customer, 
			BindingResult theBindingResult ) {
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-confirmation";
		}
		
	}
}
