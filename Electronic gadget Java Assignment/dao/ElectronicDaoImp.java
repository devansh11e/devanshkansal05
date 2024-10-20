package com.hexaware.electronicgadget.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.electronicgadget.entity.Inventory;
import com.hexaware.electronicgadget.entity.Customer;
import com.hexaware.electronicgadget.entity.Orderdetails;
import com.hexaware.electronicgadget.entity.Orders;
import com.hexaware.electronicgadget.entity.Products;
public  class ElectronicDaoImp implements IElectronicDao
{
	private Connection conn;

	public ElectronicDaoImp() {

		this.conn = DBUtil.getDBConnection();
	    if (this.conn == null) {
	        throw new RuntimeException("Failed to establish a database connection");
	    }
}

	@Override
	public List<Customer> allcustomer() {
      List<Customer> list=new ArrayList<Customer>();
		
		String selectAll="select * from customers";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int customerID=rs.getInt("customerID");
				String firstName=rs.getString("FirstName");
				String lastName=rs.getString("LastName");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				
				Customer cust=new Customer(customerID,firstName,lastName,email,phone,address);
				list.add(cust);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Inventory> allInventory() {
      List<Inventory> list=new ArrayList<Inventory>();
		
		String selectAll="select *from inventory";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int inventoryID=rs.getInt("InventoryID");
				int productID=rs.getInt("ProductID");
				int quantityInStock=rs.getInt("quantityInStock");
				Date lastStockUpdate=rs.getDate("lastStockUpdate");
				
				Inventory inv=new Inventory(inventoryID,productID,quantityInStock,lastStockUpdate);
				list.add(inv);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Orderdetails> allorderdetails() {
    List<Orderdetails> list=new ArrayList<Orderdetails>();
		
		String selectAll="select *from orderdetails";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int orderDetailID=rs.getInt("orderDetailID");
				int orderID=rs.getInt("OrderID");
				int productID=rs.getInt("ProductID");
				int quantity=rs.getInt("quantity");
				
				
				Orderdetails orde=new Orderdetails(orderDetailID,orderID,productID,quantity);
				list.add(orde);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Orders> allorders() {
     List<Orders> list=new ArrayList<Orders>();
		
		String selectAll="select * from orders";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int orderID=rs.getInt("orderID");
				int customerID=rs.getInt("customerID");
				Date orderdate=rs.getDate("OrderDate");
				double totalamount=rs.getDouble("TotalAmount");
				String paymentID=rs.getString("PaymentID");
				String orderstatus=rs.getString("orderstatus");
				
				
				Orders ord=new Orders(orderID,customerID,orderdate,totalamount,paymentID,orderstatus);
				list.add(ord);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Products> allproducts() {
		 List<Products> list=new ArrayList<Products>();
			
			String selectAll="select *from products";
			try {
				PreparedStatement pstmt=conn.prepareStatement(selectAll);
				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					int productID=rs.getInt("productID");
					String productname=rs.getString("Productname");
					String description=rs.getString("Description");
					double price=rs.getDouble("price");
					
					
					
					Products pro=new Products(productID,productname,description,price);
					list.add(pro);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}

	@Override
	public int addcustomer(Customer cust) {
        int count=0;
		
		String insert="insert into customers(customerID,firstname,lastname,email,phone,address) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
		
			pstmt.setInt(1, cust.getCustomerID());
			pstmt.setString(2, cust.getFirstName());
			pstmt.setString(3, cust.getLastName());
			pstmt.setString(4, cust.getEmail());
			pstmt.setString(5, cust.getPhone());
			pstmt.setString(6, cust.getAddress());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updatecustomer(Customer cust) {
        int count=0;
		
		String updateQuery="update customers set firstname=?,lastname=?,email=?,phone=?,address=? where CustomerID=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateQuery);
		
			
			pstmt.setString(1, cust.getFirstName());
			pstmt.setString(2, cust.getLastName());
			pstmt.setString(3, cust.getEmail());
			pstmt.setString(4, cust.getPhone());
			pstmt.setString(5, cust.getAddress());
			pstmt.setInt(6, cust.getCustomerID());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deletecustomer(Customer cust) {
           int count=0;
		
		String delete="delete from customers where customerId=?";
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, cust.getCustomerID());
			
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return count;
	}

	@Override
	public int newproduct(Products pro) {
         int count=0;
		
		String insert="insert into products(ProductID,productname,description,price) values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
		
			pstmt.setInt(1,pro.getProductID());
			pstmt.setString(2, pro.getProductName());
			pstmt.setString(3, pro.getDescription());
			pstmt.setDouble(4, pro.getPrice());
			
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateproduct(Products pro) {
     int count=0;
		
		String updateQuery="update products set productname=?,description=?,price=? where productID=? ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateQuery);
		
			
			pstmt.setString(1, pro.getProductName());
			pstmt.setString(2, pro.getDescription());
			pstmt.setDouble(3, pro.getPrice());
			pstmt.setInt(4,pro.getProductID());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteproduct(Products pro) {
       int count=0;
		
		String delete="delete from product where productID=? ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(delete);
			pstmt.setInt(1,pro.getProductID());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int addorder(Orders ord) {
        int count=0;
		
		String insert="insert into orders(OrderID,CustomerID,OrderDate,TotalAmount,PaymentID,OrderStatus) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
		
			pstmt.setInt(1,ord.getOrderID());
			pstmt.setInt(2, ord.getCustomerID());
			pstmt.setDate(3, (Date) ord.getOrderDate());
			pstmt.setDouble(4, ord.getTotalAmount());
			pstmt.setString(5,ord.getPaymentid());
			pstmt.setString(6, ord.getOrderstatus());
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateorder(Orders ord) {
		 int count=0;
			
			String updateQuery="update orders set CustomerID=?,OrderDate=?,TotalAmount=?,PaymentID=?,OrderStatus=? where orderID=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(updateQuery);
			
				
				pstmt.setInt(1, ord.getCustomerID());
				pstmt.setDate(2, (Date) ord.getOrderDate());
				pstmt.setDouble(3, ord.getTotalAmount());
				pstmt.setString(4,ord.getPaymentid());
				pstmt.setString(5, ord.getOrderstatus());
				pstmt.setInt(6,ord.getOrderID());
				count=pstmt.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
	}

	@Override
	public int deleteorder(Orders ord) {
           int count=0;
		
		String delete="delete from orders where orderID=? ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(delete);
			pstmt.setInt(1,ord.getOrderID());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateinventory(Inventory inv) {
         int count=0;
		
		String updateQuery="update inventory set quantityinstock=?,laststockupdate=? where InventoryID=? ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateQuery);
		
			
			pstmt.setInt(1, inv.getQuantityInStock());
			pstmt.setDate(2, (Date) inv.getLastStockUpdate());
			pstmt.setInt(3,inv.getInventoryID());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Orders> totalorders() {
      List<Orders> list=new ArrayList<Orders>();
		
		String selectAll="select count(*) as TotalOrders,CustomerID from orders group by CustomerID";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				
				int customerID=rs.getInt("customerID");
				Orders ord=new Orders(0, customerID, null, 0, selectAll, selectAll);
				list.add(ord);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Orders> payments() {
        List<Orders> list=new ArrayList<Orders>();
		
		String selectAll="select totalamount,paymentID from orders";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				double totalamount=rs.getDouble("TotalAmount");
				String paymentID=rs.getString("PaymentID");
				
				
				Orders ord=new Orders(0, 0, null, totalamount,paymentID, null);
				list.add(ord);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Orders> orderstatus() {
     List<Orders> list=new ArrayList<Orders>();
		
		String selectAll="select orderID,orderstatus from orders";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int orderID=rs.getInt("orderID");
				String orderstatus=rs.getString("orderstatus");
				
				
				Orders ord=new Orders(orderID,0, null, 0, null, orderstatus);
				list.add(ord);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;

	}

	@Override
	public Products getbyPid(int productID) {
		
		Products pr=null;
		String selectAll="select * from products where productId = ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.setInt(1,productID);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int productID1=rs.getInt("productID");
				String productname1=rs.getString("Productname");
				String description=rs.getString("Description");
				double price=rs.getDouble("price");
				
				
				  pr=new Products(productID1,productname1,description,price);
			}	
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pr;
	}

	@Override
	public Products getbyPname(String productname) {
		Products pr=null;
		String selectAll="select * from products where productname = ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.setString(1,productname);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int productID=rs.getInt("productID");
				String productname1=rs.getString("Productname");
				String description=rs.getString("Description");
				double price=rs.getDouble("price");
				
				
				  pr=new Products(productID,productname1,description,price);
			}	
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pr;
}

	@Override
	public Inventory isproductinstock(int productID) {
		Inventory in=null;
		String selectAll="select productID,quantityinStock from Inventory where productID = ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.setInt(1,productID);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int productID1=rs.getInt("productID");
				int quantityinStock=rs.getInt("quantityinStock");
				
				
				  in=new Inventory(productID1,quantityinStock, quantityinStock, null);
			}	
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return in;
		
	}

	@Override
	public int cancelorder(Orders ord) {
		int count=0;
		
		String updateQuery="update orders set OrderStatus='Cancel' where orderID=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateQuery);
		
			pstmt.setInt(1,ord.getOrderID());
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public int updatequantity(Inventory inv) {
		 int count=0;
			
			String updateQuery="update Inventory set quantityinStock=? where productID=? ";
			try {
				PreparedStatement pstmt=conn.prepareStatement(updateQuery);
			
				
				pstmt.setInt(1, inv.getQuantityInStock());
				pstmt.setInt(2,inv.getProductID());
				
				
				count=pstmt.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
	}


	@Override
	public int addinventory(Inventory inv) {
        int count=0;
		
		String insert="insert into Inventory(InventoryID,productID,quantityinStock,laststockupdate) values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
		
			pstmt.setInt(1,inv.getInventoryID());
			pstmt.setInt(2, inv.getProductID());
			pstmt.setInt(3, inv.getQuantityInStock());
			pstmt.setDate(4, (Date) inv.getLastStockUpdate());
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteinventory(Inventory inv) {
      int count=0;
		
		String delete="delete from Inventory where InventoryID=? ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(delete);
			pstmt.setInt(1,inv.getInventoryID());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Inventory inventoryvalue(Inventory inv) {
		Inventory inv1=null;
		String selectAll="select SUM(quantityiStock*price) as TotalValue from Inventory";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.executeQuery();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inv1;
	}

	@Override
	public List<Inventory> quantityinstock() {
List<Inventory> list=new ArrayList<Inventory>();
		
		String selectAll="select *from inventory where quantityinStock>0";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int inventoryID=rs.getInt("InventoryID");
				int productID=rs.getInt("ProductID");
				int quantityInStock=rs.getInt("quantityInStock");
				Date lastStockUpdate=rs.getDate("lastStockUpdate");
				
				Inventory inv=new Inventory(inventoryID,productID,quantityInStock,lastStockUpdate);
				list.add(inv);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Inventory> lowstockproducts() {
List<Inventory> list=new ArrayList<Inventory>();
		
		String selectAll="select *from inventory where quantityinStock<10";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int inventoryID=rs.getInt("InventoryID");
				int productID=rs.getInt("ProductID");
				int quantityInStock=rs.getInt("quantityInStock");
				Date lastStockUpdate=rs.getDate("lastStockUpdate");
				
				Inventory inv=new Inventory(inventoryID,productID,quantityInStock,lastStockUpdate);
				list.add(inv);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Inventory> outofstock() {
List<Inventory> list=new ArrayList<Inventory>();
		
		String selectAll="select *from inventory where quantityinStock=0";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int inventoryID=rs.getInt("InventoryID");
				int productID=rs.getInt("ProductID");
				int quantityInStock=rs.getInt("quantityInStock");
				Date lastStockUpdate=rs.getDate("lastStockUpdate");
				
				Inventory inv=new Inventory(inventoryID,productID,quantityInStock,lastStockUpdate);
				list.add(inv);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Orders> totalamount() {
		 List<Orders> list=new ArrayList<Orders>();
			
			String selectAll="select orderID,totalamount from orders";
			try {
				PreparedStatement pstmt=conn.prepareStatement(selectAll);
				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					int orderID=rs.getInt("orderID");
					double totalamount=rs.getDouble("TotalAmount");
					
					
					Orders ord=new Orders(orderID,0,null,totalamount,null,null);
					list.add(ord);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}
}





	


