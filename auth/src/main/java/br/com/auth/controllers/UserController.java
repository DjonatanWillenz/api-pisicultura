package br.com.auth.controllers;

import br.com.auth.dtos.PasswordUpdateDTO;
import br.com.auth.dtos.UserCreateDTO;
import br.com.auth.dtos.UserDTO;
import br.com.auth.services.UserService;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("public/user")
    public ResponseEntity<Serializable> post(@RequestBody UserCreateDTO user) {
        try {
            return ResponseEntity.ok().body(userService.save(user));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).build();
            // .body(RestDto.builder()
            // .message(e.getMessage())
            // .build());
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<Serializable> path(@RequestBody UserDTO user, @PathVariable Long iduser) {
        try {
            return null;// ResponseEntity.ok(userService.path(iduser, user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long iduser) {
        try {
            // userService.delete(iduser);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(value = "user/password/{id}")
    public ResponseEntity<Serializable> updatePassword(@RequestBody PasswordUpdateDTO dto) {
        try {
            return null;// ResponseEntity.ok().body(userService.updatePassword(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("user/comfirm/{username}/{key}")
    public ResponseEntity<Serializable> confirmRegister(
            @PathVariable("username") String username, @PathVariable("key") String key) {
        try {
            return null;// ResponseEntity.ok(userService.confirmRegister(username, key));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
