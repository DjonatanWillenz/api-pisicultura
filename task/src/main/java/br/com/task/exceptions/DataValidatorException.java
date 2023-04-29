package br.com.task.exceptions;

import br.com.task.dtos.AvisoDTO;
import br.com.task.enums.AvisoEnum;

public class DataValidatorException extends Exception {

	private static final long serialVersionUID = 1L;

	private Integer code;
	private AvisoEnum type;
	private String message;
	private Object data;

	public DataValidatorException(String message, AvisoEnum type) {
		this.type = type;
		this.message = message;
	}

	public DataValidatorException(String message, AvisoEnum type, Object data) {
		this.type = type;
		this.message = message;
		this.data = data;
	}

	public DataValidatorException(String message, AvisoEnum type, Object data, Integer code) {
		this.type = type;
		this.message = message;
		this.data = data;
		this.code = code;
	}

	public Integer getCode() {
		return this.code > 0 ? this.code : 500;
	}

	public AvisoDTO getResponse() {
		return AvisoDTO.builder().type(type).message(message).data(data).build();
	}
}
