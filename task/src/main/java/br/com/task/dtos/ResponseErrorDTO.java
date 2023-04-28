package br.com.task.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class ResponseErrorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private Date time;
	private List<String> erros;
	
}
