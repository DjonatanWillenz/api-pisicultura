package br.com.api.enums;

import lombok.Getter;

@Getter
public enum WsNotificationEnum {
    
    NOTIFICAATION("Mensagem de notificação"),
    CHAT("Menagem de chat");

    private String description;

    WsNotificationEnum(String description){
        this.description = description;
    }
}
