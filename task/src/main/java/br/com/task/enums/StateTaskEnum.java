package br.com.task.enums;

import lombok.Getter;

@Getter
public enum StateTaskEnum {
    WAITING("Aguardando"),
    SEND("Enviado solicitação"),
    STARTED("Iniciado"),
    PAUSED("Pusada"),
    CONCLUSED("Concluido"),
    FINISHED("Finalizado");

    private String description;

    StateTaskEnum(String description) {
        this.description = description;
    }

}
