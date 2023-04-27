package br.com.api.enums;

import lombok.Getter;

@Getter
public enum TemperatureStateEnum {
    
    CHANGED("Alterado"),
    NORMAL("Normal");

    private String description;

    TemperatureStateEnum(String description) {
        this.description = description;
    }
}
