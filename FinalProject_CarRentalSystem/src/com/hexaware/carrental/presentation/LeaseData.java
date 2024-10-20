package com.hexaware.carrental.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.hexaware.carrental.entity.Customer;
import com.hexaware.carrental.entity.Lease;
import com.hexaware.carrental.entity.Vehicle;
import com.hexaware.carrental.exception.CustomerrNotFoundException;
import com.hexaware.carrental.exception.InvalidDataException;
import com.hexaware.carrental.exception.LeaseNotFoundException;
import com.hexaware.carrental.service.CarLeaseServiceImpl;

public class LeaseData {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		CarLeaseServiceImpl service=new CarLeaseServiceImpl();
		System.out.println("***Welcome To Lease Data***");
		System.out.println("1.Add Lease");
		System.out.println("2.Find Lease by LeaseID");
		System.out.println("3.List All Active Leases");
		System.out.println("4.List of Lease History");
		int choice1=scanner.nextInt();
		switch(choice1)
		{ case 1: try{Lease le=readleaseData();
		boolean isValid;
		 isValid = CarLeaseServiceImpl.validateCst1(le);
	    if(isValid) {
	    int count =	service.createLease(le);
	     if(count>0) {
		System.out.println("Lease Added");
	                 }
		}}
     catch (InvalidDataException e) {
    	 System.err.println("Lease Added failed due to invalid LeaseID ");
             }
			 break;
			 
			 
		case 2: try{System.out.println("Enter LeaseID=");
		int l1=(scanner.nextInt());
		Lease count2=service.returnCar(l1);
		if(count2!=null) {
		System.out.println(count2);	}}
		catch(LeaseNotFoundException e)
       { System.err.println("LeaseId not found.");
       System.out.println(" ");
       System.out.println(" ");}
			 break;
			 
			 
		case 3: List<Lease> list1= service.listActiveLeases();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Loop through the list of leases and check if they are active
        for (Lease le : list1) {
            // Convert the endDate from string to LocalDate
            LocalDate endDate = LocalDate.parse(le.getEndDate(), formatter); // Assuming getEndDate() gives the date in dd-MM-yyyy format

            // Check if the current date is less than the end date
            if (currentDate.isBefore(endDate)) {
                // Print the active lease
                System.out.println(le);
            }
        }
			 break;
			 
			 
		case 4:List<Lease> list2= service.listLeaseHistory();
        for (Lease le1: list2){
        System.out.println(le1);
         }
			break;
			
		default:System.out.println("Invalid Choice");
	     break;
		
		}
	
	}
	public static Lease readleaseData(){
		Lease lea= new Lease();
		
		System.out.println("Enter LeaseID=");
			lea.setLeaseId(scanner.nextInt());
			System.out.println("Enter VehicleID=");
		    int vehicleId = scanner.nextInt();
		    
		    // Initialize the Vehicle object before setting the vehicleId
		    Vehicle vehicle = new Vehicle();  // Create a new Vehicle object
		    vehicle.setVehicleId(vehicleId);  // Set the vehicleId in the Vehicle object
		    lea.setVehicle(vehicle);  // Set the Vehicle object in the Lease
		    
		    // Initialize and set Customer, Dates, and Type
		    System.out.println("Enter CustomerID=");
		    int customerId = scanner.nextInt();
		    Customer customer = new Customer();
		    customer.setCustomerId(customerId);
		    lea.setCustomer(customer);
		System.out.println("Enter Start Date=");
			lea.setStartDate(scanner.next());
		System.out.println("Enter End Date=");
			lea.setEndDate(scanner.next());
		System.out.println("Enter Type");
			lea.setType(scanner.next());
		
		return lea;
	}	
}
