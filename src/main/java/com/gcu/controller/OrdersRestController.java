package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.model.OrderModel;

@RestController
@RequestMapping("/service")
public class OrdersRestController {
	private @Autowired OrdersBusinessInterface service;
	
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrdersAsJson(){
		return service.getOrders();
	}
	
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public List<OrderModel> getOrdersAsXml(){
		return service.getOrders();
	}
}
