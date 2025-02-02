package com.gcu.data.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.OrderModel;

public class OrdersDataService {

	@Autowired
	private OrdersRepository ordersRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	//Non-Default constructor for constructor injection
	
	public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource)
	{
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public boolean create(OrderModel order) {
		//Example of 'overriding' the CrudRepository save() because it simply is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?,?,?,?)";
		try {
			//Execute SQL Insert
			jdbcTemplateObject.update(sql,
					order.getOrderNo(),
					order.getProductName(),
					order.getPrice(),
					order.getQuantity()
					);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
