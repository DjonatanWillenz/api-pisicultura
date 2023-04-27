package br.com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.services.DashboardService;
import br.com.api.utils.UtilsJson;

@RestController
@RequestMapping("/app/dashboard")
public class DashboardAppController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/{id}/{idinstallation}")
    public ResponseEntity<String> get(@PathVariable Long id, @PathVariable Long idinstallation) {
        try {
            return ResponseEntity.ok(
                    UtilsJson.getInstance().toJson(dashboardService.dataApp()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
