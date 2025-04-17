package com.carconnect.dao;

import com.carconnect.model.Customer;

public interface ICustomerServiceDao {
	void registerCustomer(Customer customer);
	void updateCustomer(String firstName, int customerId);
	void deleteCustomer(int customerId);
	Customer getById(int customerId);
	Customer getByUserName(String username);
}