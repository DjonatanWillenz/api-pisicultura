package br.com.task.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Integer code;
    @Default
    private Date current_time = new Date();
    private String message;
    private Integer countRegister;
    private Object data;
    
}
