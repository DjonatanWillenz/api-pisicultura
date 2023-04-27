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
    private String email;
    private String name;
    private String password;
    private String token;
    private Boolean admin;

}
