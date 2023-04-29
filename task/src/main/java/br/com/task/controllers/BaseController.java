package br.com.task.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.task.dtos.AvisoDTO;
import br.com.task.enums.AvisoEnum;
import br.com.task.exceptions.DataValidatorException;

@Component
public class BaseController {

	protected ResponseEntity<AvisoDTO> buildCreateSuccess(Object data) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(AvisoDTO.builder().type(AvisoEnum.SUCCESS).message("Created with success.").data(data).build());
	}

	protected ResponseEntity<AvisoDTO> buildResponseRegistersSuccess(List<?> data) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(AvisoDTO.builder().type(AvisoEnum.SUCCESS).message("Response data.").data(data).build());
	}

	protected ResponseEntity<AvisoDTO> buildError(Exception e) {
		return buildError(e, HttpStatus.BAD_REQUEST);
	}

	protected ResponseEntity<AvisoDTO> buildError(Exception e, HttpStatus state) {
		if (e.getClass().equals(DataValidatorException.class)) {
			DataValidatorException data = (DataValidatorException) e;
			return ResponseEntity.status(state).body(data.getResponse());
		}
		return ResponseEntity
				.ok(AvisoDTO.builder().type(AvisoEnum.ERROR).message("Error internal server 500.").build());
	}
}
