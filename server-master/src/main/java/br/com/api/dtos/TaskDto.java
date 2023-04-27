package br.com.api.dtos;

import java.io.Serializable;
import java.util.Date;

import br.com.api.enums.TaskStatusEnum;
import br.com.api.enums.TaskEnum;
import lombok.*;

@Getter
@Setter
@Builder
public class TaskDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Date dateCreate;
    private Date dateConclused;
    private TaskStatusEnum status;
    private Long userCreated;
    private Long installation;
    private TaskEnum task;
    private String key;
}
