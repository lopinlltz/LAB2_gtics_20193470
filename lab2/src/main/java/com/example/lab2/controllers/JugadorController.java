package com.example.lab2.controllers;

import com.example.lab2.entity.Jugador;
import com.example.lab2.repository.JugadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lab2")
public class JugadorController {
    final JugadorRepository jugadorRepository;
    public JugadorController(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @GetMapping("/jugador")
    public String listar(Model model) {
        List<Jugador> listajugadores = jugadorRepository.findAll();
        model.addAttribute("listajugadores", listajugadores);
        return "lab2/jugador";
    }

    @GetMapping("/jugador/nuevo")
    public String crear() {
        return "lab2/jugador/nuevo";
    }

    @PostMapping("/jugador/guardar")
    public String guardar(Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/lab2/jugador";
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {

        Optional<Jugador> optional = jugadorRepository.findById(id);

        if (optional.isPresent()) {
            jugadorRepository.deleteById(id);
        }
        return "redirect:/lab2/jugador";
    }
}
