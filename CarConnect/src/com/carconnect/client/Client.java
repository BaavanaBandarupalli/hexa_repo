package com.carconnect.client;

import java.time.LocalDate;

import com.carconnect.dao.CustomerServiceDaoImpl;
import com.carconnect.dao.ICustomerServiceDao;
import com.carconnect.model.Customer;

public class Client {
	public static void main(String[] args) {
		Customer customer = new Customer(1, "Riya", "Manoj", "riya@gmail.com",
				"9876543210", "Hyderabad", "riyamanoj", "riya@123", LocalDate.now());
		Customer customer1 = new Customer(2, "Priya", "Raj", "priya@gmail.com",
				"9876543211", "Chennai", "priyaraj", "priya@123", LocalDate.now());
		Customer customer2 = new Customer(3, "Rahul", "Dev", "rahul@gmail.com",
				"9876543212", "Kochi", "rahuldev", "rahul@123", LocalDate.now());
		Customer customer3 = new Customer(4, "Rishi", "Nair", "riya@gmail.com",
				"9876543213", "Coimbatore", "rishinair", "rishi@123", LocalDate.now());
		Customer customer4 = new Customer(5, "Raja", "Ram", "riya@gmail.com",
				"9876543214", "Bangalore", "rajaram", "raja@123", LocalDate.now());
		
		ICustomerServiceDao customerService = new CustomerServiceDaoImpl();
		
	    customerService.registerCustomer(customer);
		customerService.registerCustomer(customer1);
		customerService.registerCustomer(customer2);
		customerService.registerCustomer(customer3);
	    customerService.registerCustomer(customer4);
		
		customerService.updateCustomer("Sanjay", 4);

		customerService.deleteCustomer(2);
		
		customer = customerService.getById(3);
		if (customer != null) {
            System.out.println("Customer Details:");
            System.out.println("ID: " + customer.getCustomerID());
            System.out.println("FirstName: " + customer.getFirstName());
            System.out.println("LastName: " + customer.getLastName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhoneNumber());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Username: " + customer.getUsername());
            System.out.println("Registered on: " + customer.getRegistrationDate());
        } else {
            System.out.println("No customer found");
        }
		
		customer = customerService.getByUserName("rajaram");
		if (customer != null) {
			System.out.println("Customer Details:");
			System.out.println("ID: " + customer.getCustomerID());
	        System.out.println("FirstName: " + customer.getFirstName());
	        System.out.println("LastName: " + customer.getLastName());
	        System.out.println("Email: " + customer.getEmail());
	        System.out.println("Phone: " + customer.getPhoneNumber());
	        System.out.println("Address: " + customer.getAddress());
	        System.out.println("Username: " + customer.getUsername());
	        System.out.println("Registered on: " + customer.getRegistrationDate());
	     } else {
	         System.out.println("No customer found");
		}
	}
}
