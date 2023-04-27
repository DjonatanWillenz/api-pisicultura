package br.com.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.api.configs.Properties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = Properties.SCHEMA, name = "requestpassword")
public class RequestPassword implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private UserSystem user;

    private String key;
    private Date date;
    private boolean concluded;
}
