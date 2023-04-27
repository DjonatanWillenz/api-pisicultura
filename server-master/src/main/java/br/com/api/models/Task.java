package br.com.api.models;

import br.com.api.enums.TaskStatusEnum;
import br.com.api.configs.Properties;
import br.com.api.enums.TaskEnum;
import br.com.api.utils.UtilsJson;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = Properties.SCHEMA, name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(name = "datecreate")
    private Date dateCreate;

    @Column(name = "dateconclused")
    private Date dateConclused;

    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "idinstallation")
    private Installation installation;

    @Enumerated(EnumType.STRING)
    private TaskEnum task;

    private String key;

    @Column(name = "lastattempt")
    private Date lastAttempt;

    public String toString() {
        return UtilsJson.getInstance().toJson(this);
    }

}
