package com.hexaware.carrental.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLIntegrityConstraintViolationException;
import com.hexaware.carrental.entity.Customer;
import com.hexaware.carrental.entity.Lease;
import com.hexaware.carrental.entity.Vehicle;
import com.hexaware.carrental.exception.CarNotFoundException;
import com.hexaware.carrental.exception.CustomerrNotFoundException;
import com.hexaware.carrental.exception.DuplicateDataException;
import com.hexaware.carrental.exception.LeaseNotFoundException;
import com.hexaware.carrental.util.DBConnection;
import com.hexaware.carrental.entity.Payment;

public class CarLeaseRepositoryImpl implements ICarLeaseRepository{
	private Connection conn;

	public CarLeaseRepositoryImpl() {

		conn = DBConnection.getConnection();
}


	@Override
	public int addCar(Vehicle vehicle) throws DuplicateDataException,SQLException{
		int count=0;
		String insert="insert into vehicle(vehicleId,make,model,year,dailyRate,status,passengerCapacity,engineCapacity) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			pstmt.setInt(1, vehicle.getVehicleId());
			pstmt.setString(2, vehicle.getMake());
			pstmt.setString(3, vehicle.getModel());
			pstmt.setInt(4, vehicle.getYear());
			pstmt.setDouble(5, vehicle.getDailyRate());
			pstmt.setString(6, vehicle.getStatus());
			pstmt.setInt(7, vehicle.getPassengerCapacity());
			pstmt.setInt(8, vehicle.getEngineCapacity());
			
			count=pstmt.executeUpdate();
		
		} catch (SQLIntegrityConstraintViolationException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                // Throw a custom message when duplicate entry for 'CustomerId' occurs
                throw new DuplicateDataException("Duplicate entry for VehicleId: ");
            }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.printf("\"Database error: \"" + e.getMessage(), e);
		}
		return count;
		
	}

	@Override
	public int removeCar(int vehicleID) throws CarNotFoundException{
		 int count=0;
			
			String delete="delete from vehicle where vehicleID=?";
			
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(delete);
				pstmt.setInt(1,vehicleID);
				
				count=pstmt.executeUpdate();
			 if(count==0)
				{ throw new CarNotFoundException("Vehicle Not Found");
				}}
			catch (SQLException e) {
				
				
				e.printStackTrace();
			}
			
		
			return count;
		
	}

	@Override
	public List<Vehicle> listAvailableCars() {
		// TODO Auto-generated method stub
       List<Vehicle> list=new ArrayList<Vehicle>();
		
		String selectAll="select * from vehicle where status='available' ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int vehicleId=rs.getInt("vehicleID");
				String make=rs.getString("Make");
				String model=rs.getString("model");
				int year=rs.getInt("year");
				Double dailyRate=rs.getDouble("DailyRate");
				String Status=rs.getString("Status");
				int passengerCapacity=rs.getInt("PassengerCapacity");
				int EngineCapacity=rs.getInt("EngineCapacity");
				
				Vehicle vehicle=new Vehicle(vehicleId,make,model,year,dailyRate,Status,passengerCapacity,EngineCapacity);
				list.add(vehicle);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

	@Override
	public List<Vehicle> listRentedCars() {
		// TODO Auto-generated method stub
		 List<Vehicle> list=new ArrayList<Vehicle>();
			
			String selectAll="select * from vehicle where status='not available' ";
			try {
				PreparedStatement pstmt=conn.prepareStatement(selectAll);
				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					int vehicleId=rs.getInt("vehicleID");
					String make=rs.getString("Make");
					String model=rs.getString("model");
					int year=rs.getInt("year");
					Double dailyRate=rs.getDouble("DailyRate");
					String Status=rs.getString("Status");
					int passengerCapacity=rs.getInt("PassengerCapacity");
					int EngineCapacity=rs.getInt("EngineCapacity");
					
					Vehicle vehicle=new Vehicle(vehicleId,make,model,year,dailyRate,Status,passengerCapacity,EngineCapacity);
					list.add(vehicle);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}

	@Override
	public Vehicle findCarbyId(int vehicleID) throws CarNotFoundException{
		Vehicle vehicle=null;
		String selectAll="select * from vehicle where vehicleID = ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.setInt(1,vehicleID);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int vehicleId=rs.getInt("vehicleID");
				String make=rs.getString("Make");
				String model=rs.getString("model");
				int year=rs.getInt("year");
				Double dailyRate=rs.getDouble("DailyRate");
				String Status=rs.getString("Status");
				int passengerCapacity=rs.getInt("PassengerCapacity");
				int EngineCapacity=rs.getInt("EngineCapacity");
				
				
				  vehicle=new Vehicle(vehicleId,make,model,year,dailyRate,Status,passengerCapacity,EngineCapacity);
			}	
			else { throw new CarNotFoundException("Vehicle Not Found");}	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vehicle;
	}

	@Override
	public int addCustomer(Customer customer) throws DuplicateDataException, SQLException {
		int count=0;
		String insert="insert into customer(customerId,firstname,lastname,email,phone) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			pstmt.setInt(1, customer.getCustomerId());
			pstmt.setString(2, customer.getFirstName());
			pstmt.setString(3, customer.getLastName());
			pstmt.setString(4, customer.getEmail());
			pstmt.setLong(5, customer.getPhoneNumber());
			
			count=pstmt.executeUpdate();
		
		} catch (SQLIntegrityConstraintViolationException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                // Throw a custom message when duplicate entry for 'CustomerId' occurs
                throw new DuplicateDataException("Duplicate entry for CustomerId: ");
            }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.printf("\"Database error: \"" + e.getMessage(), e);
		}
		return count;
	
		
	}

	@Override
	public int removeCustomer(int customerID) throws CustomerrNotFoundException{
       int count=0;
		
		String delete="delete from customer where customerID=?";
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1,customerID);
			
			count=pstmt.executeUpdate();
			if(count==0)
			{ throw new CustomerrNotFoundException("Customer Not Found");}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		return count;
		
	}

	@Override
	public List<Customer> listofAllCustomers() {
      List<Customer> list=new ArrayList<Customer>();
		
		String selectAll="select * from customer ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int customerId=rs.getInt("customerID");
				String firstName=rs.getString("firstname");
				String lastName=rs.getString("lastname");
				String email=rs.getString("email");
			    long phoneNumber=rs.getLong("phone");
				
				
				Customer customer=new Customer(customerId,firstName,lastName,email,phoneNumber);
				list.add(customer);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Customer findCustomerbyId(int customerID) throws CustomerrNotFoundException{
       
		Customer customer=null;
		String selectAll="select * from customer where customerID = ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.setInt(1,customerID);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int customerId=rs.getInt("customerID");
				String firstName=rs.getString("firstname");
				String lastName=rs.getString("lastname");
				String email=rs.getString("email");
				long phoneNumber=rs.getLong("phone");
				
				
				  customer=new Customer(customerId,firstName,lastName,email,phoneNumber);
			}	
			else	
			{ throw new CustomerrNotFoundException("Customer Not Found");}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}

	@Override
	public int createLease(Lease lease) throws DuplicateDataException,SQLException{
		int count=0;
		String insert="insert into lease(leaseId,VehicleId,CustomerId,startdate,enddate,type) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			pstmt.setInt(1, lease.getLeaseId());
			pstmt.setInt(2, lease.getVehicle().getVehicleId());
			pstmt.setInt(3, lease.getCustomer().getCustomerId());
			pstmt.setString(4, lease.getStartDate());
			pstmt.setString(5, lease.getEndDate());
			pstmt.setString(6,lease.getType());
			
			count=pstmt.executeUpdate();
		
		} catch (SQLIntegrityConstraintViolationException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                // Throw a custom message when duplicate entry for 'CustomerId' occurs
                throw new DuplicateDataException("Duplicate entry for LeaseId: ");
            }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.printf("\"Database error: \"" + e.getMessage(), e);
		}
		return count;
	}

	@Override
	public Lease returnCar(int leaseID) throws LeaseNotFoundException{
		Lease lease=null;
		String selectAll="select * from lease where leaseId = ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.setInt(1,leaseID);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int leaseId=rs.getInt("LeaseID");
				String startDate=rs.getString("startDate");
				String endDate=rs.getString("endDate");
				String type=rs.getString("Type");
				// Assuming Vehicle and Customer objects are fetched via their IDs (to be implemented)
                int vehicleId = rs.getInt("vehicleID");
                int customerId = rs.getInt("customerID");
             // Fetch Vehicle and Customer objects (implement the methods as needed)
                Vehicle vehicle = findCarbyId(vehicleId);
                Customer customer = findCustomerbyId(customerId);
               
                
		     lease=new Lease(leaseId,vehicle,customer,startDate,endDate,type);
			}
			else { throw new LeaseNotFoundException("Lease Not Found");}
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
		catch (CarNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomerrNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lease;
	}

	@Override
	public List<Lease> listActiveLeases() {
		 List<Lease> list=new ArrayList<Lease>();
			
			String selectAll="select * from lease;";
			try {
				PreparedStatement pstmt=conn.prepareStatement(selectAll);
				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					 int leaseId = rs.getInt("leaseID");
		                String startDate = rs.getString("startDate");
		                String endDate = rs.getString("endDate");
		                String type = rs.getString("type");
		                
		                // Assuming Vehicle and Customer objects are fetched via their IDs (to be implemented)
		                int vehicleId = rs.getInt("vehicleID");
		                int customerId = rs.getInt("customerID");
		             // Fetch Vehicle and Customer objects (implement the methods as needed)
		                Vehicle vehicle = findCarbyId(vehicleId);
		                Customer customer = findCustomerbyId(customerId);
		               
		                
				    Lease lease=new Lease(leaseId,vehicle,customer,startDate,endDate,type);
					list.add(lease);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CarNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CustomerrNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}

	@Override
	public List<Lease> listLeaseHistory() {
       List<Lease> list=new ArrayList<Lease>();
		
		String selectAll="select * from lease ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int leaseId=rs.getInt("LeaseID");
				String startDate=rs.getString("startDate");
				String endDate=rs.getString("endDate");
				String type=rs.getString("Type");
				 // Assuming Vehicle and Customer objects are fetched via their IDs (to be implemented)
                int vehicleId = rs.getInt("vehicleID");
                int customerId = rs.getInt("customerID");
             // Fetch Vehicle and Customer objects (implement the methods as needed)
                Vehicle vehicle = findCarbyId(vehicleId);
                Customer customer = findCustomerbyId(customerId);
               
                
		    Lease lease=new Lease(leaseId,vehicle,customer,startDate,endDate,type);
			list.add(lease);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CarNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomerrNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int recordPayment(Payment payment)throws DuplicateDataException,SQLException {
		int count=0;
		String insert="insert into payment(paymentID,LeaseId,paymentDate,amount) values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			pstmt.setInt(1, payment.getPaymentId());
			pstmt.setInt(2, payment.getLease().getLeaseId());
			pstmt.setString(3, payment.getPaymentDate());
			pstmt.setDouble(4, payment.getAmount());
			
			count=pstmt.executeUpdate();
		
		} catch (SQLIntegrityConstraintViolationException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                // Throw a custom message when duplicate entry for 'CustomerId' occurs
                throw new DuplicateDataException("Duplicate entry for PaymentId: ");
            }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.printf("\"Database error: \"" + e.getMessage(), e);
		}
		return count;
	}
		
	
	

}
