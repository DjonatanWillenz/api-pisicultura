package br.com.api.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCreateDto implements Serializable {
    private String name;
    private String username;
    private String email;
    private String password;
}
