package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.model.OrderModel;

@RestController
@RequestMapping("/service")
public class OrdersRestController {

    private static final Logger logger = LoggerFactory.getLogger(OrdersRestController.class);

	private OrdersBusinessInterface service;

    public OrdersRestController(OrdersBusinessInterface service) {
        logger.info("Initializing OrdersRestController");
        this.service = service;
    }
	
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrdersAsJson(){
        logger.info("Fetching orders as JSON");
		return service.getOrders();
	}
	
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public List<OrderModel> getOrdersAsXml(){
        logger.info("Fetching orders as XML");
		return service.getOrders();
	}
}
