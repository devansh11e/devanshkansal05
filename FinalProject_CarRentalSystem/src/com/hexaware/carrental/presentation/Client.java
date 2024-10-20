package com.hexaware.carrental.presentation;

import java.util.Scanner;

public class Client {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		VehicleData ve=new VehicleData();
		CustomerData cu=new CustomerData();
		LeaseData le=new LeaseData();
		PaymentData pa=new PaymentData();
		boolean flag=true;
		while(flag)
		{System.out.println("***Welcome To Car Rental***");
		System.out.println("1.Vehicle Data");
		System.out.println("2.Customer Data");
		System.out.println("3.Lease Data ");
		System.out.println("4.Payment Data");
		System.out.println("0.Exit");
		int choice=scanner.nextInt();
		switch (choice)
		{ case 1: ve.main(args);
		    break;
		case 2: cu.main(args);
			break;
		case 3: le.main(args);
			break;
		case 4: pa.main(args);
			break;
		case 0:System.out.println("Exit");
	     break;
		default:System.out.println("Invalid Choice");
		     break;
		}
		
		}
		
     
	}
	

}
