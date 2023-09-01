package com.example.lab2.controllers;

import com.example.lab2.repository.JugadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/lab2")
public class JugadorController {
    final JugadorRepository jugadorRepository;
    public JugadorController(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @GetMapping("/jugador")
    public String listar(Model model) {
        model.addAttribute("listajugadores", jugadorRepository.findAll());
        return "lab2/jugador";
    }
}
