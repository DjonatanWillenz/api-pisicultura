package br.com.auth.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO implements Serializable {
    private String username;
    private String password;
}
