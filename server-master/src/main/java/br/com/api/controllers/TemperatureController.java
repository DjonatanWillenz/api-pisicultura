package br.com.api.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dtos.TemperatureDto;
import br.com.api.models.Temperature;
import br.com.api.services.TemperatureService;

@RestController
@RequestMapping("/app/temperature")
public class TemperatureController {

    @Autowired
    private TemperatureService temService;

    @PostMapping
    public ResponseEntity<Serializable> save(@RequestBody() @Valid TemperatureDto dto) {
        try {
            return ResponseEntity.ok(temService.save(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Temperature>> find(
            @RequestParam(name = "idinstallation", required = false) Long idinstallation,
            @RequestParam(name = "idtemp", required = false) Long idtemp) {
        try {
            if (idinstallation != null) {
                return ResponseEntity.ok(temService.findByIdInstallation(idinstallation));
            } else if (idtemp != null) {
                List<Temperature> temp = new ArrayList<>();
                temp.add(temService.findById(idtemp));
                return ResponseEntity.ok(temp);
            } else
                return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
