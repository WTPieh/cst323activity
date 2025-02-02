package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.data.repository.OrdersRepository;
import com.gcu.model.OrderModel;
import com.gcu.data.entity.*;

public class OrdersBusinessSerivce implements OrdersBusinessInterface {

	@Autowired
	private OrdersRepository service;
	@Autowired
	private DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void test() {
		System.out.println("Hello from OrdersBusinessService");
	}
	
	

	@Override
	public List<OrderModel> getOrders()
	{
		var ordersDomain = new ArrayList<OrderModel>();
        var ordersEntity = service.findAll();
        
        for (OrderEntity entity : ordersEntity) {
        	ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
        }
        
		
		return ordersDomain;
	}

	@Override
	public void init() {
		System.out.println("Calling method init() in OrdersBusinessService");
		
	}

	@Override
	public void destroy() {
		System.out.println("Calling method destroy() in OrdersBusinessService");
		
	}
}
