package br.com.api.enums;

import lombok.Getter;

@Getter
public enum SettingsEnum {
    
    INTERVAL_UPDATE_TASK_PH(""),
    INTERVAL_UPDATE_TASK_TEMPERATURE(""),
    INTERVAL_UPDATE_TASK_FOOD(""),
    ACTIVE_SERVICE_TASK_PH(""),
    ACTIVE_SERVICE_TASK_TEMPERATURE(""),
	ACTIVE_SERVICE_TASK_FOOD("");

    private String description;

    SettingsEnum(String description) {
        this.description = description;
    }
}
