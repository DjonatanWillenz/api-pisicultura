package br.com.auth.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserSessionDTO implements Serializable {
    
    private String id;
    private String username;
    private String password;
    private String email;
    private String token;
    private Boolean admin;
    private String name;

}
