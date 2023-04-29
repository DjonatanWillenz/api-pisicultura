package br.com.task.configs;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.task.exceptions.DataValidatorException;

@RestControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataValidatorException.class)
	public ResponseEntity<Object> handleUserNotFoundException(DataValidatorException exception, WebRequest request) {
		return new ResponseEntity<>(exception.getResponse(), new HttpHeaders(), exception.getCode());
	}
}
