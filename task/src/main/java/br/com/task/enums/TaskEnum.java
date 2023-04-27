package br.com.task.enums;

import lombok.Getter;

@Getter
public enum TaskEnum {
    
    PH("Verificar ph da água"),
    TEMPERATURE("Verificar temperatura da água"),
    FOOD("Executar rotina de alimentação");

    private String descriprion;

    TaskEnum(String description){
        this.descriprion = description;
    }
}
