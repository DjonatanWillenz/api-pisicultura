package br.com.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashbordController {

    @GetMapping("/dashboard")
    public String home() {
        return "teste";
    }
}
