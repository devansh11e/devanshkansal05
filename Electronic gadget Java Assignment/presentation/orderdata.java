package com.hexware.electronicgadget.presentation;

import java.util.List;
import java.util.Scanner;

import com.hexaware.electronicgadget.entity.Customer;
import com.hexaware.electronicgadget.entity.Orders;
import com.hexaware.electronicgadget.entity.Products;
import com.hexaware.electronicgadget.service.ElectronicServiceImp;

public class orderdata {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
	ElectronicServiceImp service=new ElectronicServiceImp();
	System.out.println("***Welcome To Orders***");
    System.out.println("1.TotalAmount of Order");
    System.out.println("2.Display all Orders");
    System.out.println("3.Display Order Status");
    System.out.println("4.Cancel Order");
    System.out.println("5.Add Order");
 int choice3=scanner.nextInt();
 	switch(choice3)
 	{ case 1:  List<Orders> list1 = service.totalamount();

		for (Orders ord1 : list1) {

			System.out.println(ord1);

			}
 		break;
      case 2: List<Orders> list2 = service.allorders();

		for (Orders ord2 : list2) {

			System.out.println(ord2);

			}
    	  break;
      case 3: List<Orders> list3 = service.orderstatus();

		for (Orders ord2 : list3) {

			System.out.println(ord2);

			}
    	  break;
      case 4: Orders ord1=readord1Data();
	     int count1 =	service.cancelorder(ord1);
			
  		if(count1>0) {
  				System.out.println("Order updated");
  				}
  		else{
	      System.err.println("Order Update failed");
	
  			}
    	  break;
      case 5: Orders ord2=readordData();
      int count2 =	service.addorder(ord2);
		
			if(count2>0) {
			System.out.println("Order Added");
			}
			else{
			System.err.println("Order Added failed");
			
			}	
    	   break;
 	default:System.out.println("Invalid Choice");
 		break;

     }

	}
	public static Orders readordData(){
		Orders ord3= new Orders();
		
		System.out.println("Enter OrderID=");
			ord3.setOrderID(scanner.nextInt());
		System.out.println("Enter CustomerID=");
			ord3.setCustomerID(scanner.nextInt());
		System.out.println("Enter Order Date");
			ord3.setOrderDate(scanner.nextDate());
		System.out.println("Enter Total Amount");
			ord3.setTotalAmount(scanner.nextDouble());
		System.out.println("Enter paymentID");
			ord3.setPaymentid(scanner.next());
		System.out.println("Enter Status");
			ord3.setOrderstatus(scanner.next());
		
		return ord3;
	}	
	public static Orders readord1Data(){
	 Orders ord4= new Orders();
		
		System.out.println("Enter OrderID=");
			ord4.setCustomerID(scanner.nextInt());
			return ord4;
	}

}
