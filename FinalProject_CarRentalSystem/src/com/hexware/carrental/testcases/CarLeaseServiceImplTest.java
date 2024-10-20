package com.hexware.carrental.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.hexaware.carrental.entity.Lease;
import com.hexaware.carrental.entity.Vehicle;
import com.hexaware.carrental.exception.CarNotFoundException;
import com.hexaware.carrental.exception.CustomerrNotFoundException;
import com.hexaware.carrental.exception.LeaseNotFoundException;
import com.hexaware.carrental.entity.Customer;
import com.hexaware.carrental.service.CarLeaseServiceImpl;
import com.hexaware.carrental.service.ICarLeaseService;
class CarLeaseServiceImplTest {
    static ICarLeaseService service;
	
    @BeforeAll  
	public static void beforeAll() {
		
		service = new CarLeaseServiceImpl();
		
	}
    @Test
	@Disabled
	void testAddCar() {
		
		Vehicle ve = new Vehicle(3,"Maruti","Ertiga",2021,2100,"Available",7,1900);
		
		int count = service.addCar(ve);
		
		assertTrue(count > 0);
		
		
	}
    @Test
	@Disabled
	void testAddLease() {
		
		Lease le = new Lease(3,null, null, "01-03-2023","07-03-2023","DailyLease");
		
		int count = service.createLease(le);
		
		assertTrue(count > 0);
		
	}
    
    @Test
	void GetLeasebyId() throws LeaseNotFoundException {
		
			Lease le1 = service.returnCar(1);
		
			assertEquals(1, le1.getLeaseId());
		
	}
    
    @Test
    void testLeaseNotFoundException() {
        // Simulate a non-existing lease ID
        int nonExistingLeaseId = 50;

        LeaseNotFoundException exception = assertThrows(LeaseNotFoundException.class,() -> {
            service.returnCar(nonExistingLeaseId);
        });

        assertEquals("Lease Not Found", exception.getMessage());
    }

    @Test
    void testCustomerNotFoundException() {
        // Simulate a non-existing customer ID
        int nonExistingCustomerId = 50;

        CustomerrNotFoundException exception = assertThrows(CustomerrNotFoundException.class, () -> {
            service.findCustomerbyId(nonExistingCustomerId); // assuming this method exists
        });

        assertEquals("Customer Not Found", exception.getMessage());
    }

    @Test
    void testVehicleNotFoundException() {
        // Simulate a non-existing vehicle ID
        int nonExistingVehicleId = 50;

        CarNotFoundException exception = assertThrows(CarNotFoundException.class, () -> {
            service.findCarbyId(nonExistingVehicleId); // assuming this method exists
        });

        assertEquals("Vehicle Not Found", exception.getMessage());
    }

}
