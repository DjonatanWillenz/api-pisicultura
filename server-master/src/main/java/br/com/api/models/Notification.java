package br.com.api.models;

import java.io.Serializable;

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
import br.com.api.enums.NotificationEnum;
import br.com.api.enums.NotificationStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = Properties.SCHEMA, name = "notification")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "idinstallation")
    private Installation installation;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private UserSystem user;

    @Enumerated(EnumType.STRING)
    private NotificationEnum type;

    @Enumerated(EnumType.STRING)
    private NotificationStateEnum state;
}
