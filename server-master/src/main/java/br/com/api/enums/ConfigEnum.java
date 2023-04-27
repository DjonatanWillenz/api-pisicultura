package br.com.api.enums;

import lombok.Getter;

@Getter
public enum ConfigEnum {

    PRIVILEGE("Nível de privilégio do usuário"),
    FOOD("Notificar ao identificar erro ao tentar disparar rotina de tratar"),
    PH("Notificar ao ocorrer uma alteração do ph da água fora do padrão"),
    CYCLE("Notificar ao ocorrer um problema com o motor que realiza o ciclo de limpeza");

    private String descricao;

    ConfigEnum(String descricao){
        this.descricao = descricao;
    }
}
