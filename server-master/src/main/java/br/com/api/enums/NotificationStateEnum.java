package br.com.api.enums;

import lombok.Getter;

@Getter
public enum NotificationStateEnum {
   
    PENDING("Pendente de envio"),
    ERROR("Erro ao tentar enviar"),
    DELIVERED("Entregue"),
    READ("Visualizada");

    private String description;

    NotificationStateEnum(String description) {
        this.description = description;
    }
}
