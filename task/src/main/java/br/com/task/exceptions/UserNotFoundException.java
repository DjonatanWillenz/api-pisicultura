package br.com.task.exceptions;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	UserNotFoundException(String message) {
		super(message);
	}

}
