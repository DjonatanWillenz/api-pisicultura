package br.com.api.enums;

import lombok.Getter;

@Getter
public enum TaskStatusEnum {
    WAITING("Aguardando"),
    SEND("Enviado solicitação"),
    STARTED("Iniciado"),
    PAUSED("Pusada"),
    CONCLUSED("Concluido"),
    FINISHED("Finalizado");

    private String description;

    TaskStatusEnum(String description) {
        this.description = description;
    }

}
