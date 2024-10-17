package com.hexaware.electronicgadget.service;

import java.util.List;

import com.hexaware.electronicgadget.entity.Inventory;
import com.hexaware.electronicgadget.entity.Customer;
import com.hexaware.electronicgadget.entity.Orderdetails;
import com.hexaware.electronicgadget.entity.Orders;
import com.hexaware.electronicgadget.entity.Products;

public interface IElectronicService {
	List<Customer> allcustomer();
	List<Inventory> allInventory();
	List<Orderdetails> allorderdetails();
	List<Orders> allorders();
	List<Products> allproducts();
	int addcustomer(Customer cust);
	int updatecustomer(Customer cust);
	int deletecustomer(Customer cust);
	int newproduct(Products pro);
	int updateproduct(Products pro);
    int deleteproduct(Products pro);
    int addorder(Orders ord);
	int updateorder(Orders ord);
	int deleteorder(Orders ord);
	int cancelorder(Orders ord);
	int addinventory(Inventory inv);
	int updateinventory(Inventory inv);
	int deleteinventory(Inventory inv);
	Inventory inventoryvalue(Inventory inv);
	int updatequantity(Inventory inv);
	List<Orders>  totalorders();
	List<Orders> payments();
	List<Orders> orderstatus();
	List<Inventory> quantityinstock();
	List<Inventory> lowstockproducts();
	List<Inventory> outofstock();
	List<Orders> totalamount();
	Products getbyPid(int productID);
	Products getbyPname(String productname);
	Inventory isproductinstock(int productID);

}
