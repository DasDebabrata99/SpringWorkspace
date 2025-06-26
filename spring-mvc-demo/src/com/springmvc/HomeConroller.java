package com.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeConroller {	
	@RequestMapping("/")
	public String showHomePage() {
		return "main-menu";
	}
}
