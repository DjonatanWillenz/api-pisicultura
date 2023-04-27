package br.com.api.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SettingsDto implements Serializable {  
    private Long iduser;
    private boolean notify;
}
