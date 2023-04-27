package br.com.api.enums;

import lombok.Getter;

@Getter
public enum PrivilegeEnum {
    NORMAL("Normal"),
    ADMIN("Admin");

    private String privilege;

    PrivilegeEnum(String privilege) {
        this.privilege = privilege;
    }

}
