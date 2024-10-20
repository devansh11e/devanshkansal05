package com.hexaware.carrental.presentation;

import java.util.List;
import java.util.Scanner;

import com.hexaware.carrental.entity.Customer;
import com.hexaware.carrental.entity.Vehicle;
import com.hexaware.carrental.exception.CarNotFoundException;
import com.hexaware.carrental.exception.CustomerrNotFoundException;
import com.hexaware.carrental.exception.InvalidDataException;
import com.hexaware.carrental.service.CarLeaseServiceImpl;

public class VehicleData {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		CarLeaseServiceImpl service=new CarLeaseServiceImpl();
		System.out.println("***Welcome To Vehicle Data***");
		System.out.println("1.Add Car");
		System.out.println("2.Remove Car");
		System.out.println("3.List of Available Cars");
		System.out.println("4.List of Rented Cars");
		System.out.println("5.Find Car by VehicleID");
		int choice1=scanner.nextInt();
		switch(choice1)
		{ case 1: try{Vehicle v=readvehicleData();
		boolean isValid;
		
		isValid = CarLeaseServiceImpl.validateCst2(v);
	    if(isValid) {
	int count =	service.addCar(v);
	
	if(count>0) {
		System.out.println("Vehicle Added");
	}
		
	}}
     catch (InvalidDataException e) {
    	 System.err.println("Customer Added failed due to invalid VehicleID ");
    }
			 break;
			 
			 
		case 2: try{System.out.println("Enter VehicleID=");
		int v1=(scanner.nextInt());
		int count2=service.removeCar(v1);
		if(count2>0) {
			System.out.println("Vehicle  removed");	}}
		catch(CarNotFoundException e)
       { System.err.println("vehicle not found.");}
			 break;
			 
			 
		case 3: List<Vehicle> list1= service.listAvailableCars();
        for (Vehicle v2 : list1){
        System.out.println(v2);
         }
			 break;
			 
			 
		case 4: List<Vehicle> list2= service.listRentedCars();
        for (Vehicle v3 : list2){
        System.out.println(v3);
         }
			break;
			
			
		case 5:try{System.out.println("Enter Vehicle ID");
        int vid =scanner.nextInt();
       Vehicle v4 =service.findCarbyId(vid);
       if(v4 != null)	
    	   System.out.println(v4);
		}
		catch(CarNotFoundException e)
		{ System.err.println("Vehicle not found.");
		   System.out.println(" ");}
			break;
			
			
		default:System.out.println("Invalid Choice");
	     break;
		
		}
	
	}
	
	public static Vehicle readvehicleData(){
		Vehicle v2= new Vehicle();
		
		System.out.println("Enter VehicleID=");
			v2.setVehicleId(scanner.nextInt());
		System.out.println("Enter Make=");
			v2.setMake(scanner.next());
		System.out.println("Enter Model=");
			v2.setModel(scanner.next());
		System.out.println("Enter Year 'yyyy' =");
			v2.setYear(scanner.nextInt());
		System.out.println("Enter DailyRate=");
			v2.setDailyRate(scanner.nextDouble());
		System.out.println("Enter Status 'Available or Not Available' =");
			v2.setStatus(scanner.next()); 
		System.out.println("Enter PassengerCapacity=");
			v2.setPassengerCapacity(scanner.nextInt());
		System.out.println("Enter EngineCapacity=");
			v2.setEngineCapacity(scanner.nextInt());
		
		return v2;
	}	
}
