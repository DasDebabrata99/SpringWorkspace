package com.crm.service;

import java.util.List;

import com.crm.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomerList();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
	public void deleteCustomer(int theId);
}
