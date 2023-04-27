package br.com.api.enums;

import lombok.Getter;

@Getter
public enum SendMailStateEnum {
    PENDENTING("Aguardando envio"),
    CONCLUSED("Envio realizado"),
    ERROR("Error ao realizar o envio");

    private String description;

    SendMailStateEnum(String description) {
        this.description = description;
    }
}
