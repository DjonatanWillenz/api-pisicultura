package br.com.api.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InstallationSettingsDto implements Serializable {
    private String key;
    private String value;
}
