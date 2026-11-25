package com.loachamin.deportes.controller;

import com.loachamin.deportes.model.Vuelo;
import com.loachamin.deportes.service.VueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    // TRAER TODOS
    @GetMapping
    public List<Vuelo> verTodos() {
        return vueloService.traerTodos();
    }

    // GUARDAR
    @PostMapping
    public ResponseEntity<Vuelo> guardar(@RequestBody Vuelo vuelo) {
        Vuelo nuevoVuelo = vueloService.guardar(vuelo);
        return new ResponseEntity<>(nuevoVuelo, HttpStatus.CREATED);
    }

    // CASO ESPECIAL
    @GetMapping("/destino/{ciudad}")
    public List<Vuelo> porDestino(@PathVariable String ciudad) {
        return vueloService.porDestino(ciudad);
    }
}