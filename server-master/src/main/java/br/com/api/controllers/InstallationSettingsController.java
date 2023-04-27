package br.com.api.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dtos.InstallationSettingsDto;
import br.com.api.models.InstallationSettings;
import br.com.api.services.InstallationSettingsService;

@RestController
@RequestMapping("/app/installation-setting")
public class InstallationSettingsController {

    @Autowired
    private InstallationSettingsService settingsService;

    @GetMapping
    public ResponseEntity<Serializable> get(
            @RequestParam("idinstallation") Long idinstallation,
            @RequestParam("key") String key) {
        try {
            InstallationSettings setting = settingsService.findByIdInstallationAndKey(idinstallation, key);
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(
                            InstallationSettingsDto.builder()
                                    .key(setting.getKey())
                                    .value(setting.getValue())
                                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @PutMapping(value = "/{idinstallation}")
    public ResponseEntity<Void> post(
            @PathVariable Long idinstalatio,
            @RequestBody InstallationSettingsDto dto) {
        try {
            settingsService.save(idinstalatio, dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @GetMapping(value = "/settings/{idinstallation}")
    public ResponseEntity<List<InstallationSettingsDto>> getSettingsInstallation(
            @PathVariable Long idinstalation) {
        try {
            return ResponseEntity.accepted().body(settingsService.findByIdInstallation(idinstalation));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
