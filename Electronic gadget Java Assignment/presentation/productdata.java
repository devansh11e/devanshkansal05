package com.hexware.electronicgadget.presentation;

import java.util.List;
import java.util.Scanner;

import com.hexaware.electronicgadget.entity.Inventory;
import com.hexaware.electronicgadget.entity.Customer;
import com.hexaware.electronicgadget.entity.Products;
import com.hexaware.electronicgadget.service.ElectronicServiceImp;

public class productdata {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
	ElectronicServiceImp service=new ElectronicServiceImp();
	System.out.println("***Welcome To Product Data***");
    System.out.println("1.Display All Products");
    System.out.println("2.Update Product");
    System.out.println("3.Is Product In Stock?");
    System.out.println("4.Add product");

 int choice2=scanner.nextInt();
 	switch(choice2)
 	{ case 1: List<Products> list = service.allproducts();

         for (Products pro1 : list) {

          System.out.println(pro1);

          }
 		break;
      case 2: Products pro2=readprodata();
	     int count =	service.updateproduct(pro2);
			
  			if(count>0) {
  				System.out.println("Product updated");
  				}
  			else{
  				System.err.println("product update failed");
	
  				}
    	  break;
      case 3: System.out.println("Enter ProductID to Check");

				int pid =scanner.nextInt();
		
					Inventory in1 =	service.isproductinstock(pid);
	
						if(in1 != null)	
							System.out.println(in1);
						break;
      case 4: Products pro1=readprodata();
      int count1 =	service.newproduct(pro1);
		
			if(count1>0) {
			System.out.println("Product Added");
			}
			else{
			System.err.println("Product Added failed");
			
			}	
    	   break;
 	default:System.out.println("Invalid Choice");
 		break;

     }

	}
	public static Products readprodata()
	{ Products pro=new Products();
	System.out.println("Enter ProductID=");
	pro.setProductID(scanner.nextInt());
	System.out.println("Enter Product Name=");
	pro.setProductName(scanner.next());
	System.out.println("Enter Price=");
	pro.setPrice(scanner.nextInt());
	System.out.println("Enter Description=");
	pro.setDescription(scanner.next());
	return pro;
	}
	
}
