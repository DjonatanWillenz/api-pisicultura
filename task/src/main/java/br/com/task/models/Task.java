package br.com.task.models;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.task.enums.TaskEnum;
import br.com.task.enums.StateTaskEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("task")
public class Task implements Serializable {

    @Id
    private String  id;
    private String title;
    private String description;

    private Date dateCreate;

    private Date dateConclused;

    private StateTaskEnum state;

    @DBRef
    private Installation installation;

    private TaskEnum task;

    private String key;

    private Date lastAttempt;
 
    
}
