package com.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.boot.demo.entity.InstructorDetail;

@Service
public class InstructorService {

	@Autowired
	InstructorRepository repository;
	
	public List<InstructorDetail> getInstructors() {
		return (List<InstructorDetail>) repository.findAll();
	}

	@Async
	public void executeAsynchronously() throws InterruptedException {
		
		System.out.println("Executed by == " + Thread.currentThread().getName());
		Thread.sleep(15000);
		System.out.println(Thread.currentThread().getName() + " now thread back alive ");
	}
}
