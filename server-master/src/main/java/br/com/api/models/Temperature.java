package br.com.api.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.api.configs.Properties;
import br.com.api.enums.RunEnum;
import br.com.api.enums.TemperatureStateEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = Properties.SCHEMA, name = "temperature")
public class Temperature implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TemperatureStateEnum state;

    @Enumerated(EnumType.STRING)
    private RunEnum run;

    @ManyToOne
    @JoinColumn(name = "idinstallation")
    private Installation installation;

    private Date date;
    private BigDecimal value;
    
}
