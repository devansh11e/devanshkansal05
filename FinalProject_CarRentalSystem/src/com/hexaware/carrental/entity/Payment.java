package com.hexaware.carrental.entity;

import java.sql.Date;

public class Payment {
	 private int paymentId;
	 private Lease lease;
	 private String paymentDate;
	 private double amount;
	public Payment() {
		super();
	}
	
	public Payment(int paymentId, Lease lease, String paymentDate, double amount) {
		super();
		this.paymentId = paymentId;
		this.lease = lease;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Lease getLease() {
		return lease;
	}

	public void setLease(Lease lease) {
		this.lease = lease;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", lease=" + lease + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	}

	
	 

}
