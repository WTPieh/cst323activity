package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController{
	@Autowired
	private OrdersBusinessInterface service;
	@Autowired
	private SecurityBusinessService security;
	
	
	@GetMapping("/")
	public String display(Model model) {
	    // Set model attributes
	    model.addAttribute("title", "Login Form");
	    model.addAttribute("loginModel", new LoginModel()); 
	    
	    // Return the view name
	    return "login";
	}
	
	@PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
        	model.addAttribute("title", "Login Form");
        	return "login";
        }
     

        // Set model attributes
        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", service.getOrders());

        //Running autowired OrdersBusinessInterface
        service.test();
        //Running autowired SecurityBusinessService
        security.authenticate(null, null);
        //Running init() and destroy() that we added to the bean
        service.init();
        service.destroy();
        // Return the view name
        return "orders";
    }
}