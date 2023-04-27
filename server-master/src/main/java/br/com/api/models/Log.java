package br.com.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.api.configs.Properties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = Properties.SCHEMA, name = "log")
public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String message;
    private String log;
    private String decription;
}
