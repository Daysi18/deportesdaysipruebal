package com.loachamin.deportes.controller;

import com.loachamin.deportes.model.Jugador;
import com.loachamin.deportes.service.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // TRAER TODOS
    @GetMapping
    public List<Jugador> verTodos() {
        return jugadorService.traerTodos();
    }

    // TRAER UNO
    @GetMapping("/{id}")
    public ResponseEntity<Jugador> traerUno(@PathVariable int id) {
        return jugadorService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GUARDAR
    @PostMapping
    public ResponseEntity<Jugador> guardar(@RequestBody Jugador jugador) {
        Jugador nuevoJugador = jugadorService.guardar(jugador);
        return new ResponseEntity<>(nuevoJugador, HttpStatus.CREATED);
    }

    // EDITAR
    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable int id, @RequestBody Jugador jugador) {
        return jugadorService.actualizar(id, jugador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        if (jugadorService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // CASO ESPECIAL
    @GetMapping("/goles")
    public int golesTotales() {
        return jugadorService.golesTotales();
    }
}