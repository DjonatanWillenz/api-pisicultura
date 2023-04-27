package br.com.notification.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.notification.dtos.NotificationDTO;
import br.com.notification.service.NotificacaoService;
import br.com.notification.utils.ResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {

        List<NotificationDTO> response = notificacaoService.findAll()
                .stream()
                .map(i -> i.toDTO())
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                ResponseDTO.builder()
                        .code(200)
                        .countRegister(response.size())
                        .message("Request success.")
                        .data(response)
                        .build());
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> created(@RequestBody NotificationDTO notification) {
        try {
            return ResponseEntity.ok(
                    ResponseDTO.builder()
                            .code(201)
                            .countRegister(1)
                            .message("Created success.")
                            .data(notificacaoService.create(notification).toDTO())
                            .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDTO.builder()
                            .code(500)
                            .message(e.getMessage())
                            .build());
        }
    }

}
