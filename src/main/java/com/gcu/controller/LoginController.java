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
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController{

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private @Autowired OrdersBusinessInterface service;
	private @Autowired SecurityBusinessService security;

    public LoginController() {
        logger.info("Initializing LoginController");
    }
	
	
	@GetMapping("/")
	public String display(Model model) {
        logger.info("Displaying login page");
	    // Set model attributes
	    model.addAttribute("title", "Login Form");
        logger.info("Setting title to 'Login Form'");
	    model.addAttribute("loginModel", new LoginModel()); 
	    
	    // Return the view name
        logger.info("Returning view name 'login'");
	    return "login";
	}
	
	@PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        logger.info("Processing login for user: " + loginModel.getUsername());
        if (bindingResult.hasErrors())
        {
            logger.error("Validation errors occurred during login");
        	model.addAttribute("title", "Login Form");
        	return "login";
        }
     

        logger.info("Login successful for user: " + loginModel.getUsername());
        // Set model attributes
        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", service.getOrders());

        //Running autowired OrdersBusinessInterface
        service.test();
        logger.info("OrdersBusinessInterface test method executed");
        //Running autowired SecurityBusinessService
        security.authenticate(null, null);
        logger.info("SecurityBusinessService authenticate method executed");
        //Running init() and destroy() that we added to the bean
        service.init();
        service.destroy();
        logger.info("OrdersBusinessInterface init and destroy methods executed");
        // Return the view name
        return "orders";
    }
}
