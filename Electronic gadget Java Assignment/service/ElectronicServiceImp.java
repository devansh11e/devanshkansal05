package com.hexaware.electronicgadget.service;

import java.util.List;

import com.hexaware.electronicgadget.dao.ElectronicDaoImp;
import com.hexaware.electronicgadget.dao.IElectronicDao;
import com.hexaware.electronicgadget.entity.Inventory;
import com.hexaware.electronicgadget.entity.Customer;
import com.hexaware.electronicgadget.entity.Orderdetails;
import com.hexaware.electronicgadget.entity.Orders;
import com.hexaware.electronicgadget.entity.Products;
import com.hexaware.electronicgadget.exception.InvalidDataException;

public class ElectronicServiceImp implements IElectronicService{
        private IElectronicDao dao;
        public ElectronicServiceImp()
        { dao= new ElectronicDaoImp();}
	@Override
	public List<Customer> allcustomer() {
		// TODO Auto-generated method stub
		return dao.allcustomer();
	}

	@Override
	public List<Inventory> allInventory() {
		// TODO Auto-generated method stub
		return dao.allInventory();
	}

	@Override
	public List<Orderdetails> allorderdetails() {
		// TODO Auto-generated method stub
		return dao.allorderdetails();
	}

	@Override
	public List<Orders> allorders() {
		// TODO Auto-generated method stub
		return dao.allorders();
	}

	@Override
	public List<Products> allproducts() {
		// TODO Auto-generated method stub
		return dao.allproducts();
	}

	@Override
	public int addcustomer(Customer cust) {
		// TODO Auto-generated method stub
		return dao.addcustomer(cust);
	}

	@Override
	public int updatecustomer(Customer cust) {
		// TODO Auto-generated method stub
		return dao.updatecustomer(cust);
	}

	@Override
	public int deletecustomer(Customer cust) {
		// TODO Auto-generated method stub
		return dao.deletecustomer(cust);
	}

	@Override
	public int newproduct(Products pro) {
		// TODO Auto-generated method stub
		return dao.newproduct(pro);
	}

	@Override
	public int updateproduct(Products pro) {
		// TODO Auto-generated method stub
		return dao.updateproduct(pro);
	}

	@Override
	public int deleteproduct(Products pro) {
		// TODO Auto-generated method stub
		return dao.deleteproduct(pro);
	}

	@Override
	public int addorder(Orders ord) {
		// TODO Auto-generated method stub
		return dao.addorder(ord);
	}

	@Override
	public int updateorder(Orders ord) {
		// TODO Auto-generated method stub
		return dao.updateorder(ord);
	}

	@Override
	public int deleteorder(Orders ord) {
		// TODO Auto-generated method stub
		return dao.deleteorder(ord);
	}

	@Override
	public int updateinventory(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.updateinventory(inv);
	}

	@Override
	public List<Orders> totalorders() {
		// TODO Auto-generated method stub
		return dao.totalorders();
	}

	@Override
	public List<Orders> payments() {
		// TODO Auto-generated method stub
		return dao.payments();
	}

	@Override
	public List<Orders> orderstatus() {
		// TODO Auto-generated method stub
		return dao.orderstatus();
	}

	@Override
	public Products getbyPid(int productID) {
		// TODO Auto-generated method stub
		return dao.getbyPid(productID);
	}

	@Override
	public Products getbyPname(String productname) {
		// TODO Auto-generated method stub
		return dao.getbyPname(productname);
	}
	@Override
	public int cancelorder(Orders ord) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int addinventory(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.addinventory(inv);
	}
	@Override
	public int deleteinventory(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.deleteinventory(inv);
	}
	@Override
	public Inventory inventoryvalue(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.inventoryvalue(inv);
	}
	@Override
	public int updatequantity(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.updatequantity(inv);
	}
	@Override
	public List<Inventory> quantityinstock() {
		// TODO Auto-generated method stub
		return dao.quantityinstock();
	}
	@Override
	public List<Inventory> lowstockproducts() {
		// TODO Auto-generated method stub
		return dao.lowstockproducts();
	}
	@Override
	public List<Inventory> outofstock() {
		// TODO Auto-generated method stub
		return dao.outofstock();
	}
	@Override
	public List<Orders> totalamount() {
		// TODO Auto-generated method stub
		return dao.totalamount();
	}
	@Override
	public Inventory isproductinstock(int productID) {
		// TODO Auto-generated method stub
		return dao.isproductinstock(productID);
	}

public static boolean validateCst (Customer cust) throws InvalidDataException
{  
	
	
	boolean flag=false;
	if(cust.getCustomerID()>100 && cust.getFirstName().length()>5 && cust.getLastName().length()>3 && cust.getEmail().length()>7 && cust.getPhone().length()>9 && cust.getAddress().length()>5) {
		
		flag=true;
		
	}
	else
	{ throw new InvalidDataException("Invalid Email or Data ");}
	return flag;
 
}


}
