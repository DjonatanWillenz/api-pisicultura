package br.com.api.enums;

import lombok.Getter;

@Getter
public enum NotificationEnum {

    TEMPERATURE("Alteração da temperatura da água"),
    FEED("Alimentção"),
    PH("Alteração do ph da água"),
    CYCLE("Motor do ciclo de execução da limpeza do sistema");

    private String description;

    NotificationEnum(String description) {
        this.description = description;
    }
}
