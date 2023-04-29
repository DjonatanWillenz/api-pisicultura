package br.com.task.dtos;

import java.io.Serializable;

import br.com.task.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private ResponseEnum type;
	private String message;
	private Object data;
}
