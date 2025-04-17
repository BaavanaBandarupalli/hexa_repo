package com.carconnect.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.carconnect.model.Customer;
import com.carconnect.util.DbConnectionUtil;

public class CustomerServiceDaoImpl implements ICustomerServiceDao {
	static Connection connection;


	@Override
	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		connection = DbConnectionUtil.getConnection();
		
		String sql = "INSERT INTO Customer (customerId, firstName, lastName, email, phoneNumber, address, username, password, registrationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        PreparedStatement statement = null;
	        try  {
	        	statement = connection.prepareStatement(sql);
	        	
	        	statement.setInt(1, customer.getCustomerID());
	        	statement.setString(2, customer.getFirstName());
	        	statement.setString(3, customer.getLastName());
	        	statement.setString(4, customer.getEmail());
	        	statement.setString(5, customer.getPhoneNumber());
	        	statement.setString(6, customer.getAddress());
	        	statement.setString(7, customer.getUsername());
	        	statement.setString(8, customer.getPassword());
	        	statement.setDate(9, Date.valueOf(customer.getRegistrationDate()));
	            
	        	statement.execute();
	        } catch (SQLException e) {
	    	    // TODO Auto-generated catch block
	     	    e.printStackTrace();
		    } finally {
			    try {
				    statement.close();
				    connection.close();
			    } catch (SQLException e) {
			 	     // TODO Auto-generated catch block
			 	     e.printStackTrace();
			    }
		    }
	}


	@Override
	public void updateCustomer(String firstName, int customerId) {
		// TODO Auto-generated method stub
        connection = DbConnectionUtil.getConnection();
		
		String sql = "UPDATE Customer SET firstName = ? WHERE customerId = ?";

	        PreparedStatement statement = null;
	        try  {
	        	statement = connection.prepareStatement(sql);
	        	
	        	statement.setString(1, firstName);
	        	statement.setInt(2, customerId);
	        	
	        	statement.execute();
	        } catch (SQLException e) {
	    	    // TODO Auto-generated catch block
	     	    e.printStackTrace();
		    } finally {
			    try {
				    statement.close();
				    connection.close();
			    } catch (SQLException e) {
			 	     // TODO Auto-generated catch block
			 	     e.printStackTrace();
			    }
		    }
	}


	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
        connection = DbConnectionUtil.getConnection();
		
		String sql = "DELETE FROM Customer WHERE customerId = ?";

	        PreparedStatement statement = null;
	        try  {
	        	statement = connection.prepareStatement(sql);
	        	
	        	statement.setInt(1, customerId);
	        	
	        	statement.execute();
	        } catch (SQLException e) {
	    	    // TODO Auto-generated catch block
	     	    e.printStackTrace();
		    } finally {
			    try {
				    statement.close();
				    connection.close();
			    } catch (SQLException e) {
			 	     // TODO Auto-generated catch block
			 	     e.printStackTrace();
			    }
		    }
	}


	@Override
	public Customer getById(int customerId) {
		// TODO Auto-generated method stub
		connection = DbConnectionUtil.getConnection();
	    
	    String sql = "SELECT * FROM Customer WHERE customerId = ?";
	    
	    PreparedStatement statement = null;
	    Customer customer = null;

	    try {
	        statement = connection.prepareStatement(sql);
	        
	        statement.setInt(1, customerId);

	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            int id = rs.getInt("customerId");
	            String firstName = rs.getString("firstName");
	            String lastName = rs.getString("lastName");
	            String email = rs.getString("email");
	            String phoneNumber = rs.getString("phoneNumber");
	            String address = rs.getString("address");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            LocalDate registrationDate = rs.getDate("registrationDate").toLocalDate();
	            
	            customer = new Customer(id, firstName, lastName, email, phoneNumber, address, username, password, registrationDate);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				 statement.close();
				 connection.close();
			 } catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }	
		}
		return customer;
	}


	@Override
	public Customer getByUserName(String username) {
		// TODO Auto-generated method stub
    connection = DbConnectionUtil.getConnection();
	    
	    String sql = "SELECT * FROM Customer WHERE username = ?";
	    
	    PreparedStatement statement = null;
	    Customer customer = null;

	    try {
	        statement = connection.prepareStatement(sql);
	        
	        statement.setString(1, username);

	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	        	int customerId = rs.getInt("customerId");
	            String firstName = rs.getString("firstName");
	            String lastName = rs.getString("lastName");
	            String email = rs.getString("email");
	            String phoneNumber = rs.getString("phoneNumber");
	            String address = rs.getString("address");
	            String user = rs.getString("username");
	            String password = rs.getString("password");
	            LocalDate registrationDate = rs.getDate("registrationDate").toLocalDate();

	            customer = new Customer(customerId, firstName, lastName, email, phoneNumber, address, user, password, registrationDate);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				 statement.close();
				 connection.close();
			 } catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }	
		}
		return customer;
	}
	
}
