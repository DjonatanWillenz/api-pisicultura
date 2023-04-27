package br.com.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.api.enums.RunEnum;
import br.com.api.configs.Properties;
import br.com.api.enums.FoodStateEnum;
import br.com.api.enums.RationEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = Properties.SCHEMA, name = "food")
public class Food implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idinstallation")
    private Installation installation;

    @Enumerated(EnumType.STRING)
    private FoodStateEnum state;

    @Column(name = "datecreate")
    private Date dateCreate;

    @Column(name = "dateconclused")
    private Date dateConcluded;

    @Enumerated(EnumType.STRING)
    private RationEnum ration; 
    
    @Column(name = "daterunfeed")
    private Date dateRunFeed;

    @Enumerated(EnumType.STRING)
    private RunEnum run;
    
}
