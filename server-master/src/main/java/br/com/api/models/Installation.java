package br.com.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import br.com.api.configs.Properties;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = Properties.SCHEMA, name = "installation")
public class Installation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String key;
    private String description;

    @Column(name = "datecreate")
    private Date dateCreate;


    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "installation")
    private List<UserInstallation> bond;

}
