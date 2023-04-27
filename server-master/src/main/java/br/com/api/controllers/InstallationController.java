package br.com.api.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dtos.InstallationDto;
import br.com.api.services.InstallationService;
import br.com.api.services.UserInstallationService;

@RestController
@RequestMapping("/app/installation")
public class InstallationController {

    @Autowired
    private InstallationService installationService;

    @Autowired
    private UserInstallationService userInstallationService;

    @PostMapping
    public ResponseEntity<Serializable> save(@RequestBody InstallationDto installation) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(installationService.save(installation));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{iduser}")
    public ResponseEntity<List<InstallationDto>> findByIdUser(@PathVariable Long iduser) {
        try {
            return ResponseEntity.accepted().body(userInstallationService.findByIdUser(iduser));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
