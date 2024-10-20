package com.hexaware.carrental.entity;

public class Lease {
	private int leaseId;
    private Vehicle vehicle;
    private Customer customer;
	private String startDate;
	private String endDate;
	private String type;
	public Lease() {
		super();
	}
	
	public Lease(int leaseId, Vehicle vehicle, Customer customer, String startDate, String endDate, String type) {
		super();
		this.leaseId = leaseId;
		this.vehicle = vehicle;
		this.customer = customer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
	}
	public int getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Lease [leaseId=" + leaseId + ", vehicle=" + vehicle + ", customer=" + customer + ", startDate="
				+ startDate + ", endDate=" + endDate + ", type=" + type + "]";
	}

	
	
	

}
