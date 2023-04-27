package br.com.api.controllers;

import br.com.api.dtos.SettingsDto;
import br.com.api.services.SettingsService;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/user-setting")
public class UserSettingsController {

    @Autowired
    private SettingsService userSettingsService;

    @GetMapping("/{id}")
    public ResponseEntity<Serializable> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userSettingsService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody SettingsDto settings) {
       try {
        userSettingsService.update(settings);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
    }
}
