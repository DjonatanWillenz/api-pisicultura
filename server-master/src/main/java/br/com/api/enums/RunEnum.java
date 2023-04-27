package br.com.api.enums;

import lombok.Getter;

@Getter
public enum RunEnum {
    MANUAL("Executada via comando do usuário"), 
    SCHEDULED("Executada através de agendamento");

    private String description;

    RunEnum(String description) {
        this.description = description;
    }
}
