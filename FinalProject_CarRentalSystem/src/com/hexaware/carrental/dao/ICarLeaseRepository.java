package com.hexaware.carrental.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.hexaware.carrental.entity.Customer;
import com.hexaware.carrental.entity.Lease;
import com.hexaware.carrental.entity.Payment;
import com.hexaware.carrental.entity.Vehicle;
import com.hexaware.carrental.exception.CarNotFoundException;
import com.hexaware.carrental.exception.CustomerrNotFoundException;
import com.hexaware.carrental.exception.DuplicateDataException;
import com.hexaware.carrental.exception.LeaseNotFoundException;


public interface ICarLeaseRepository {
       int addCar(Vehicle vehicle)throws DuplicateDataException,SQLException;
       int removeCar(int vehicleID) throws CarNotFoundException;
       List<Vehicle> listAvailableCars();
       List<Vehicle> listRentedCars();
       Vehicle findCarbyId(int vehicleID) throws CarNotFoundException; 
       int addCustomer(Customer customer) throws DuplicateDataException,SQLException;
       int removeCustomer(int customerID) throws CustomerrNotFoundException;
       List<Customer> listofAllCustomers();
       Customer findCustomerbyId(int customerID) throws CustomerrNotFoundException;
       int createLease(Lease lease) throws DuplicateDataException,SQLException;
       Lease returnCar(int leaseID) throws LeaseNotFoundException;
       List<Lease> listActiveLeases();
       List<Lease> listLeaseHistory();
       int recordPayment(Payment payment)throws DuplicateDataException,SQLException;
       
       
}
