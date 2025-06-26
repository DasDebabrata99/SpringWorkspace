package com.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class FormController {

	// controller method to show the form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloForm";
	}
	
	//controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "formConfirmation";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processFormShout(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("studentName");
		String result = "Yo! " + name.toUpperCase();
		
		model.addAttribute("message", result);
		return "form-viewModel";
		
	}
}
