package br.com.task.dtos;

import java.io.Serializable;

import br.com.task.enums.TaskEnum;
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
public class TaskCreateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;
	private String idinstallation;
	private TaskEnum task;
}
