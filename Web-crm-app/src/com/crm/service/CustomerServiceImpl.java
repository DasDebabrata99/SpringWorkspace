package com.crm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.CustomerDAO;
import com.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDao;
	
	
	@Override	
	@Transactional
	public List<Customer> getCustomerList() {
		
		List<Customer> customerList = customerDao.getCustomerList();
		return customerList;
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDao.saveCustomer(theCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Customer customer = customerDao.getCustomer( theId);
		return customer;
	}


	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDao.deleteCustomer(theId);
		
	}

}
