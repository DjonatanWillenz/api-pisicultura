package br.com.api.controllers;

import br.com.api.dtos.PasswordUpdateDto;
import br.com.api.dtos.RestDto;
import br.com.api.dtos.UserCreateDto;
import br.com.api.dtos.UserDto;import br.com.api.services.UserService;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Serializable> post(@RequestBody UserCreateDto user) {
        try {
            return ResponseEntity.ok().body(userService.save(user));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(RestDto.builder()
                            .message(e.getMessage())
                            .build());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serializable> path(@RequestBody UserDto user, @PathVariable Long iduser) {
        try {
            return ResponseEntity.ok(userService.path(iduser, user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long iduser) {
        try {
            userService.delete(iduser);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(value = "/password/{id}")
    public ResponseEntity<Serializable> updatePassword(@RequestBody PasswordUpdateDto dto) {
        try {
            return ResponseEntity.ok().body(userService.updatePassword(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/comfirm/{username}/{key}")
    public ResponseEntity<Serializable> confirmRegister(
        @PathVariable("username") String username, @PathVariable("key") String key) {
        try {
            return ResponseEntity.ok(userService.confirmRegister(username, key));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
