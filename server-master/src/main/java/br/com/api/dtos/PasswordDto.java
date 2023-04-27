package br.com.api.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PasswordDto implements Serializable {
    private Long id;
    private String password;
    private Date date;
    private boolean active;
}
