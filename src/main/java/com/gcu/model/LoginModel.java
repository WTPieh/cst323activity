package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel
{
	@NotNull(message = "User name is required")
	@Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters")
	private String username;

	@NotNull(message = "Password is required")
	@Size(min = 6, max = 32, message = "Password must be between 6 and 32 characters")
	private String password;

    // Default
    public LoginModel() {
    	
    }
    
    // Constructor 
    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Setter method for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }

    // Setter method for password
    public void setPassword(String password) {
        this.password = password;
    }
}