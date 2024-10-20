package com.hexaware.carrental.presentation;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Scanner;

import com.hexaware.carrental.service.CarLeaseServiceImpl;
import com.hexaware.carrental.exception.CustomerrNotFoundException;
import com.hexaware.carrental.exception.InvalidDataException;
import com.hexaware.carrental.service.CarLeaseServiceImpl;
import com.hexaware.carrental.entity.Customer;

public class CustomerData {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args)  {
		CarLeaseServiceImpl service=new CarLeaseServiceImpl();
		System.out.println("***Welcome To Customer Data***");
		System.out.println("1.Add Customer");
		System.out.println("2.Remove Customer");
		System.out.println("3.List All Customers");
		System.out.println("4.Find by Customer ID");
		int choice1=scanner.nextInt();
		switch(choice1)
		{ case 1: try{Customer cust1=readCustData();
		boolean isValid;
		
		isValid = CarLeaseServiceImpl.validateCst(cust1);
	    if(isValid) {
	int count =	service.addCustomer(cust1);
	
	if(count>0) {
		System.out.println("Customer Added");
	}
		
	}}
     catch (InvalidDataException e) {
    	 System.err.println("Customer Added failed due to Invalid Email ( Your email should be in format 'example.email@test.com') or CustomerID ");
    }
			 break;
			 
			 
		case 2:
			try{System.out.println("Enter CustomerID=");
				int c1=(scanner.nextInt());
				int count2=service.removeCustomer(c1);
				if(count2>0) {
					System.out.println("Customer  removed");	}}
				catch(CustomerrNotFoundException e)
		       { System.err.println("CustomerID not found.");}
			       break;
			 
		case 3: List<Customer> list2= service.listofAllCustomers();
               for (Customer cust1 : list2){
               System.out.println(cust1);
	            }
			 break;
			 
		case 4: try{System.out.println("Enter Customer ID");
		        int cid =scanner.nextInt();
		       Customer cust3 =service.findCustomerbyId(cid);
	           if(cust3 != null)	
	          System.out.println(cust3);
		      }
		catch(CustomerrNotFoundException e)
		{ System.err.println("CustomerID not found.");}
			break;
			
			
		default:System.out.println("Invalid Choice");
	     break;
		
		}
	
	}

	public static Customer readCustData(){
		Customer cust= new Customer();
		
		System.out.println("Enter CustomerID=");
			cust.setCustomerId(scanner.nextInt());
		System.out.println("Enter Customer FirstName=");
			cust.setFirstName(scanner.next());
		System.out.println("Enter Customer Last1Name=");
			cust.setLastName(scanner.next());
		System.out.println("Enter Customer Email=");
			cust.setEmail(scanner.next());
		System.out.println("Enter Phone number=");
			cust.setPhoneNumber(scanner.nextLong());
		
		return cust;
	}	
}
