package com.portfolio.backend.Exception;

public class Exception extends RuntimeException{
    
    private static final String MESSAGE = "User not found with username %s";
	
	public Exception(String username) {
		super(String.format(MESSAGE, username));
	}
}
