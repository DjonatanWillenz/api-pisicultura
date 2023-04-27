package br.com.api.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestPasswordDto implements Serializable {
    private Long id;
    private String key;
    private Date date;
    private boolean concluded;
}
