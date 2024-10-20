package com.hexaware.carrental.presentation;

import java.util.Scanner;

import com.hexaware.carrental.entity.Customer;
import com.hexaware.carrental.entity.Lease;
import com.hexaware.carrental.entity.Payment;
import com.hexaware.carrental.entity.Vehicle;
import com.hexaware.carrental.exception.InvalidDataException;
import com.hexaware.carrental.service.CarLeaseServiceImpl;

public class PaymentData {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		CarLeaseServiceImpl service=new CarLeaseServiceImpl();
		System.out.println("***Welcome To Payment Data***");
		System.out.println("1.Record Payment");
		int choice1=scanner.nextInt();
		switch(choice1)
		{ case 1:  try{Payment pay1=readpayData();
		boolean isValid;
		
		isValid = CarLeaseServiceImpl.validateCst4(pay1);
	    if(isValid) {
	int count =	service.recordPayment(pay1);
	
	if(count>0) {
		System.out.println("Payment Added");
	}
		
	}}
     catch (InvalidDataException e) {
    	 System.err.println("Payment Added failed due to invalid PaymentID ");
    }
			 break;
		default:System.out.println("Invalid Choice");
	         break;
		
		}
	
	}
	public static Payment readpayData(){
		Payment pay2= new Payment();
		
		System.out.println("Enter PaymentID=");
			pay2.setPaymentId(scanner.nextInt());
			System.out.println("Enter LeaseID=");
		    int leaseId = scanner.nextInt();
			 Lease lease = new Lease();  // Create a new Vehicle object
			  lease.setLeaseId(leaseId);  // Set the vehicleId in the Vehicle object
			  pay2.setLease(lease);
		System.out.println("Enter Payment Date=");
			pay2.setPaymentDate(scanner.next());
		System.out.println("Enter Amount=");
			pay2.setAmount(scanner.nextDouble());
		
		return pay2;
	}	
}
