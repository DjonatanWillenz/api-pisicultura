package br.com.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.api.configs.Properties;
import br.com.api.enums.SendMailStateEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = Properties.SCHEMA, name = "sendmail")
public class SendMail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tomail;
    private String title;

    @Type(type="text")
    private String body;

    @Enumerated(EnumType.STRING)
    private SendMailStateEnum state;

    private Date date;
    private Long attempts;
}
