package com.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.entity.InstructorDetail;

@RestController
@RequestMapping("/demo")
public class InstructorController {

	@Autowired
	InstructorService service;
		
	@GetMapping("/get")
	public List<InstructorDetail> getInstructor() {
		return service.getInstructors();
	}
	
	@RequestMapping("/check")
	public void checkExecutingThreads() throws InterruptedException {
		System.out.println("This is getting executed by == " + 
				Thread.currentThread().getName());
		service.executeAsynchronously();
		Thread.sleep(9000);
		System.out.println(Thread.currentThread().getName() + "  Main thread back alive ");
	}
}
