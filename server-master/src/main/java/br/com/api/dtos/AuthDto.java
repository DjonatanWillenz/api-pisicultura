package br.com.api.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDto implements Serializable {
    private String username;
    private String password;
}
