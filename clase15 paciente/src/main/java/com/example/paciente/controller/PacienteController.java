package com.example.paciente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PacienteController {
    @GetMapping("/index")
    public String welcome(Model model){
        model.addAttribute("nombre","WELCOME DIGITAL HOUSE");
        return "index";
    }
}
