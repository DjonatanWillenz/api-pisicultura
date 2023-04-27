package br.com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.models.Food;
import br.com.api.services.FoodService;

@RestController
@RequestMapping("/app/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> getByIdInstalacao(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.ok(foodService.getByIdInstallaction(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createRequest(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.status(
                    foodService.createRequest(null)
                            ? HttpStatus.CREATED
                            : HttpStatus.BAD_REQUEST)
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
