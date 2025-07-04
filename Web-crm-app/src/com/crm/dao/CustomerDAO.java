package com.crm.dao;

import java.util.List;

import com.crm.entity.Customer;



public interface CustomerDAO {

	public List<Customer> getCustomerList();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
	public void deleteCustomer(int theId);
}
