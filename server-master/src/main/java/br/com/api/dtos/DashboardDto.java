package br.com.api.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DashboardDto {
    private double temperature;
    private double ph;
    private double oxygenation;
    private long notifications;
}
