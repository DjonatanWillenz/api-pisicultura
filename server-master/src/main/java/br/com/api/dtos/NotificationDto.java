package br.com.api.dtos;

import java.io.Serializable;

import br.com.api.enums.NotificationStateEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotificationDto implements Serializable {    
    private Long id;
    private String title;
    private String description;
    private Long iduser;
    private NotificationStateEnum state;
}
