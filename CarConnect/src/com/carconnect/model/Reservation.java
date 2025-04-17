package com.carconnect.model;

import java.time.LocalDateTime;

public class Reservation {
	int reservationID;
	int customerID;
	int vehicleID;
	LocalDateTime startDate;
	LocalDateTime endDate;
    double totalCost;
    String status;
    
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int reservationID, int customerID, int vehicleID, LocalDateTime startDate, LocalDateTime endDate,
			double totalCost, String status) {
		super();
		this.reservationID = reservationID;
		this.customerID = customerID;
		this.vehicleID = vehicleID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalCost = totalCost;
		this.status = status;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}