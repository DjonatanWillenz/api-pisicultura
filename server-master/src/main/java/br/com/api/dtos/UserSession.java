package br.com.api.dtos;

import java.io.Serializable;
import java.util.Date;

import br.com.api.models.UserSystem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserSession implements Serializable{
    private String token;
    private UserSystem user;
    private Date dateCon;
}
