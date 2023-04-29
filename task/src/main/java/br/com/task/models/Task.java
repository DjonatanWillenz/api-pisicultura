package br.com.task.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.task.dtos.TaskDTO;
import br.com.task.enums.StateTaskEnum;
import br.com.task.enums.TaskEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("task")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String description;
	private Date dateCreate;
	private Date dateConclused;
	private StateTaskEnum state;
	private String idinstallation;
	private TaskEnum task;
	private String key;
	private Date lastAttempt;

	public TaskDTO toDTO() {
		return TaskDTO.builder()
				.id(id).description(description)
				.dateCreate(dateCreate)
				.dateConclused(dateConclused)
				.task(task)
				.state(state)
				.idinstallation(idinstallation)
				.key(key)
				.lastAttempt(lastAttempt)
				.build();
	}
}
