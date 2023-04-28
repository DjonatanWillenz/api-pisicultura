package br.com.task.configs;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.task.dtos.ResponseErrorDTO;
import br.com.task.exceptions.UserNotFoundException;

@RestControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object>  handleUserNotFoundException(  UserNotFoundException exception, WebRequest request) {
        ResponseErrorDTO apiErrorMessage = new ResponseErrorDTO(HttpStatus.NOT_FOUND.value(), new Date(), List.of(exception.getMessage()));
        return new ResponseEntity<>(apiErrorMessage, new HttpHeaders(), apiErrorMessage.getStatus());
    }
}
