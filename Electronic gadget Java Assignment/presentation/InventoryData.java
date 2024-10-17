package com.hexware.electronicgadget.presentation;

import java.util.List;
import java.util.Scanner;

import com.hexaware.electronicgadget.entity.Inventory;
import com.hexaware.electronicgadget.entity.Orders;
import com.hexaware.electronicgadget.entity.Products;
import com.hexaware.electronicgadget.service.ElectronicServiceImp;

public class InventoryData {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
	ElectronicServiceImp service=new ElectronicServiceImp();
	System.out.println("***Welcome To Inventory***");
    System.out.println("1.Get Product Details");
    System.out.println("2.Get Quantity in Stock ");
    System.out.println("3.Add to Inventory");
    System.out.println("4.Remove From Inventory");
    System.out.println("5.UpdateStock Quantity");
    System.out.println("6.Is Product Available");
    System.out.println("7.Get Inventory Value");
    System.out.println("8.List Low Stock Products");
    System.out.println("9.List Out of Stock Products");
    System.out.println("10.List All Products");
 int choice5=scanner.nextInt();
 	switch(choice5)
 	{ case 1:  System.out.println("1.By ProductID or 2. By Product Name");
 	          int choice6=scanner.nextInt();
 	                 switch(choice6)
 	                 {case 1:System.out.println("Enter Product ID");

						int pid =scanner.nextInt();
						
					  Products pro =service.getbyPid(pid);
					
					if(pro != null)	
					System.out.println(pro);
 	                	   break;
 	                 case 2:System.out.println("Enter Product Name");

						String pname =scanner.next();
						
					  Products pro1 =	service.getbyPname(pname);
					
					if(pro1 != null)	
					System.out.println(pro1);
 	                	 break;
 	                 }
 		break;
      case 2: List<Inventory> list1 = service.quantityinstock();

              for (Inventory inv1 : list1) {

              System.out.println(inv1);

              }
    	  break;
      case 3: Inventory inv2=readinvdata();
      int count1 =	service.addinventory(inv2);
		
			if(count1>0) {
			System.out.println("Inventory Added");
			}
			else{
			System.err.println("Inventory Added failed");
			
			}	
    	  break;
      case 4:  Inventory i=new Inventory();
      			System.out.println("Enter InventoryID=");
      				i.setInventoryID(scanner.nextInt());
      				int count2=service.deleteinventory(i);
      				if(count2>0) {
      					System.out.println("Inventory  removed");	}
      				else {
      					System.err.println("Inventory remove failed");
      				}
    	  break;
    	  
    	  
    	  
      case 5: Inventory inv3=readinvdata();
              int count3 =service.updateinventory(inv3);
		
			if(count3>0) {
			System.out.println("Inventory updated");
			}
			else{
			System.err.println("Inventory updated failed");
			
			}	
    	  break;
    	  
    	  
      case 6: System.out.println("Enter Product ID");
            int pid =scanner.nextInt();
	       Inventory in =service.isproductinstock(pid);
	        if(in != null)	
	        System.out.println(in);
    	  break;
    	  
    	  
      case 7:System.out.println(service.inventoryvalue(null));
    	  break;
    	  
    	  
      case 8:  List<Inventory> list2= service.lowstockproducts();

      for (Inventory inv1 : list2){

      System.out.println(inv1);

      }
    	  break;
      case 9: List<Inventory> list3= service.outofstock();

      for (Inventory inv1 : list3){

      System.out.println(inv1);

      }
    	  break;
      case 10:  List<Products>list4=service.allproducts();

      for (Products pro :list4) {

      System.out.println(pro);

      }
    	  break;
 	default:System.out.println("Invalid Choice");
 		break;
 	}

	}
	public static Inventory readinvdata()
	{ Inventory inv1=new Inventory();
	System.out.println("Enter InventoryID=");
	inv1.setInventoryID(scanner.nextInt());
	System.out.println("Enter ProductID=");
	inv1.setProductID(scanner.nextInt());
	System.out.println("Enter QuantityInStock");
	inv1.setQuantityInStock(scanner.nextInt());
	return inv1;
	}

}
