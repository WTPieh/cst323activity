package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessSerivce implements OrdersBusinessInterface {

	@Override
	public void test() {
		System.out.println("Hello from AnotherOrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders()
	{
		  // Create some Orders with default values
        List<OrderModel> orders = new ArrayList<OrderModel>();
        
        
        orders.add(new OrderModel(6L, "0000000006", "Product 6", 6.00f, 6));
        orders.add(new OrderModel(7L, "0000000007", "Product 7", 7.00f, 7));
        orders.add(new OrderModel(8L, "0000000008", "Product 8", 8.00f, 8));
        orders.add(new OrderModel(9L, "0000000009", "Product 9", 9.00f, 9));
        orders.add(new OrderModel(10L, "00000000010", "Product 10", 10.00f, 10));
		
		return orders;
	}

	@Override
	public void init() {
		System.out.println("Calling method init() in AnotherOrdersBusinessService");
		
	}

	@Override
	public void destroy() {
		System.out.println("Calling method destroy() in AnotherOrdersBusinessService");
		
	}
}
