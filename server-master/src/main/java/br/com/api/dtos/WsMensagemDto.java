package br.com.api.dtos;

import java.io.Serializable;
import java.util.Date;

import br.com.api.enums.WsNotificationEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WsMensagemDto implements Serializable {    
    private Long id;
    private Long iduserreceived;
    private String mensagem;
    private WsNotificationEnum tipo;
    private Date date;
}
