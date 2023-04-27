package br.com.api.controllers;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dtos.PhDto;
import br.com.api.models.PH;
import br.com.api.services.PhService;

@RestController
@RequestMapping("/app/ph")
public class PhController {

    @Autowired
    private PhService phService;

    @PostMapping
    public ResponseEntity<Serializable> save(@RequestBody @Valid PhDto dto) {
        try {
            return ResponseEntity.ok(phService.save(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PH>> findByIdInstallation(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(phService.findByIdInstallation(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        try {
            phService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
