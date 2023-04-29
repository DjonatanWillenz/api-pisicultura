package br.com.task.exceptions;

import br.com.task.dtos.ResponseDTO;
import br.com.task.enums.ResponseEnum;

public class RegisterNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private ResponseEnum type;
	private String message;

	public RegisterNotFoundException(String message, ResponseEnum type) {
		this.type = type;
		this.message = message;
	}

	public ResponseDTO getResponse() {
		return ResponseDTO.builder().type(type).message(message).build();
	}
}
