package br.com.auth.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PasswordUpdateDTO implements Serializable {
    private String email;
    private String old;
    private String newPass;
}
