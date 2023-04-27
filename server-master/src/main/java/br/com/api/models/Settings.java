package br.com.api.models;


import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

import br.com.api.configs.Properties;

@Getter
@Setter
@Entity
@Table(schema = Properties.SCHEMA,  name = "usersettings")
public class Settings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean notify;   
 
    @ManyToOne
    @JoinColumn(name = "iduser")
    private UserSystem user;
}
