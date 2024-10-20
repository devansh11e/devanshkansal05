package com.hexaware.carrental.service;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.carrental.dao.ICarLeaseRepository;
import com.hexaware.carrental.dao.CarLeaseRepositoryImpl;
import com.hexaware.carrental.entity.Customer;
import com.hexaware.carrental.entity.Lease;
import com.hexaware.carrental.entity.Payment;
import com.hexaware.carrental.entity.Vehicle;
import com.hexaware.carrental.exception.CarNotFoundException;
import com.hexaware.carrental.exception.CustomerrNotFoundException;
import com.hexaware.carrental.exception.DuplicateDataException;
import com.hexaware.carrental.exception.InvalidDataException;
import com.hexaware.carrental.exception.LeaseNotFoundException;

public class CarLeaseServiceImpl implements ICarLeaseService{
	private ICarLeaseRepository dao;
	public CarLeaseServiceImpl()
	{ dao=new CarLeaseRepositoryImpl();}

	@Override
	public int addCar(Vehicle vehicle) {
		// TODO Auto-generated method stub
		try {
			return dao.addCar(vehicle);
		} catch (DuplicateDataException | SQLException e) {
			System.out.println("\"Duplicate entry for VehicleId: \"");// TODO Auto-generated catch block
		}
		return 0;
	}

	@Override
	public int removeCar(int vehicleID)throws CarNotFoundException {
		
			return dao.removeCar(vehicleID);}
	

	@Override
	public List<Vehicle> listAvailableCars() {
		// TODO Auto-generated method stub
		return dao.listAvailableCars();
	}

	@Override
	public List<Vehicle> listRentedCars() {
		// TODO Auto-generated method stub
		return dao.listRentedCars();
	}

	@Override
	public Vehicle findCarbyId(int vehicleID) throws CarNotFoundException{
			return dao.findCarbyId(vehicleID);}
	

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			return dao.addCustomer(customer);
		} catch (DuplicateDataException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("\"Duplicate entry for CustomerId: \"");
		}
		return 0;
	}

	@Override
	public int removeCustomer(int customerID) throws CustomerrNotFoundException{
		// TODO Auto-generated method stub
			return dao.removeCustomer(customerID);
	}

	@Override
	public List<Customer> listofAllCustomers() {
		// TODO Auto-generated method stub
		return dao.listofAllCustomers();
	}

	@Override
	public Customer findCustomerbyId(int customerID) throws CustomerrNotFoundException  {
		return dao.findCustomerbyId(customerID);
	}

	@Override
	public int createLease(Lease lease) {
		// TODO Auto-generated method stub
		try {
			return dao.createLease(lease);
		} catch (DuplicateDataException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("\"Duplicate entry for LeaseId: \"");
		}
		return 0;
	}

	@Override
	public Lease returnCar(int leaseID)throws LeaseNotFoundException {
		// TODO Auto-generated method stub
			return dao.returnCar(leaseID);
	}

	@Override
	public List<Lease> listActiveLeases() {
		// TODO Auto-generated method stub
		return dao.listActiveLeases();
	}

	@Override
	public List<Lease> listLeaseHistory() {
		// TODO Auto-generated method stub
		return dao.listLeaseHistory();
	}

	@Override
	public int recordPayment(Payment payment) {
		// TODO Auto-generated method stub
		try {
			return dao.recordPayment(payment);
		} catch (DuplicateDataException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("\"Duplicate entry for PaymentId: \"");
		}
		return 0;
	}
	public static boolean validateCst (Customer cust) throws InvalidDataException
	{  
		
		
		boolean flag=false;
		String email1="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		if(cust.getCustomerId()>0  && cust.getEmail().matches(email1) ) {
			
			flag=true;
			
		}
		else
		{ throw new InvalidDataException("Invalid Email ( Your email should be in format 'example.email@test.com') or CustomerID ");}
		return flag;
	 
	}
	public static boolean validateCst1 (Lease le) throws InvalidDataException
	{  
		
		
		boolean flag=false;
		if(le.getLeaseId()>0  ) {
			
			flag=true;
			
		}
		else
		{ throw new InvalidDataException("Invalid Lease ID ");}
		return flag;
	 
	}
	public static boolean validateCst2 (Vehicle ve) throws InvalidDataException
	{  
		
		
		boolean flag=false;
		if(ve.getVehicleId()>0  ) {
			
			flag=true;
			
		}
		else
		{ throw new InvalidDataException("Invalid Vehicle ID ");}
		return flag;
	 
	}
	public static boolean validateCst4 (Payment pay1) throws InvalidDataException
	{  
		
		
		boolean flag=false;
		if(pay1.getPaymentId()>0  ) {
			
			flag=true;
			
		}
		else
		{ throw new InvalidDataException("Invalid Payment ID ");}
		return flag;
	 
	}
	
}
