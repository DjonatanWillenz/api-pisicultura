package br.com.api.services;

import org.springframework.stereotype.Service;

import br.com.api.dtos.DashboardDto;

@Service
public class DashboardService {
    
    public DashboardDto dataApp() {
        return DashboardDto.builder()
        .temperature(26.2)
        .ph(5.6)
        .oxygenation(4.2)
        .notifications(10)
        .build();
    }
}
