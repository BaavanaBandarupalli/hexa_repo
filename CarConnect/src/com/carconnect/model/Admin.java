package com.carconnect.model;

import java.time.LocalDate;

public class Admin {
	int adminID;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String username;
    String password;
    String role;
    LocalDate joinDate;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminID, String firstName, String lastName, String email, String phoneNumber, String username,
			String password, String role, LocalDate joinDate) {
		super();
		this.adminID = adminID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.role = role;
		this.joinDate = joinDate;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	
	public void authenticatePassword(String password) {
		if(this.password.equals(password)) {
			System.out.println("Correct Password");
		} else {
		    System.out.println("Incorrect Password");
		}
	}
}