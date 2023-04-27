package br.com.api.models;

import lombok.*;

import javax.persistence.*;

import br.com.api.configs.Properties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = Properties.SCHEMA, name = "user")
public class UserSystem implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;

    @Column(name = "datecreate")
    private Date dateCreate;
    
    private boolean confirmed;
    private boolean active;
    
    @OneToOne(mappedBy = "user")
    private Email email;

    @OneToOne(mappedBy = "user")
    private Password password;

    @OneToMany(mappedBy = "user")
    private List<UserInstallation> installation;
}
