package br.com.task.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.task.dtos.ResponseDTO;
import br.com.task.enums.ResponseEnum;
import br.com.task.exceptions.DataValidatorException;
import br.com.task.exceptions.RegisterNotFoundException;

@Component
public class BaseController {

	protected ResponseEntity<ResponseDTO> buildCreateSuccess(Object data) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ResponseDTO.builder().type(ResponseEnum.SUCCESS).message("Created with success.").data(data).build());
	}

	protected ResponseEntity<ResponseDTO> buildResponseRegistersSuccess(Object data) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(ResponseDTO.builder().type(ResponseEnum.SUCCESS).message("Response data.").data(data).build());
	}

	protected ResponseEntity<ResponseDTO> buildDeleteSuccess() {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(ResponseDTO.builder().type(ResponseEnum.SUCCESS).message("Deleted with success.").build());
	}

	protected ResponseEntity<ResponseDTO> buildResponseRegistersSuccess(List<?> data) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseDTO.builder().type(ResponseEnum.SUCCESS).message("Response data.").data(data).build());
	}

	protected ResponseEntity<ResponseDTO> buildError(Exception e) {
		return buildError(e, HttpStatus.BAD_REQUEST);
	}

	protected ResponseEntity<ResponseDTO> buildError(Exception e, HttpStatus state) {
		if (e.getClass().equals(DataValidatorException.class)) {
			DataValidatorException data = (DataValidatorException) e;
			return ResponseEntity.status(state).body(data.getResponse());
		} else if (e.getClass().equals(RegisterNotFoundException.class)) {
			RegisterNotFoundException data = (RegisterNotFoundException) e;
			return ResponseEntity.status(state).body(data.getResponse());
		}
		return ResponseEntity
				.ok(ResponseDTO.builder().type(ResponseEnum.ERROR).message("Error internal server 500.").build());
	}
}
