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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = Properties.SCHEMA, name = "ph")
public class PH implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal value;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "idinstallation")
    private Installation installation;

    @Enumerated(EnumType.STRING)
    private RunEnum run;

}
