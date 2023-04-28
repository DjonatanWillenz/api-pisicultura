package br.com.task.dtos;

import java.io.Serializable;
import java.sql.Date;

import br.com.task.enums.StateTaskEnum;
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
public class TaskDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private String  id;
    private String description;
    private Date dateCreate;
    private Date dateConclused;
    private StateTaskEnum state;
    private String idinstallation;
    private TaskEnum task;
    private String key;
    private Date lastAttempt;
}
