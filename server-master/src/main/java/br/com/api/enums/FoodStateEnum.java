package br.com.api.enums;

import lombok.Getter;

@Getter
public enum FoodStateEnum {
    PENDING("Não executada"),
    CONCLUDED("Concluida");

    private String description;

    FoodStateEnum(String description) {
        this.description = description;
    }

}
