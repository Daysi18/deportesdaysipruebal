package com.loachamin.deportes.controller;

import com.loachamin.deportes.model.Mueble;
import com.loachamin.deportes.service.MuebleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/muebles")
public class MuebleController {

    private MuebleService muebleService;

    public MuebleController(MuebleService muebleService) {
        this.muebleService = muebleService;
    }

    // TRAER TODOS
    @GetMapping
    public List<Mueble> verTodos() {
        return muebleService.traerTodos();
    }

    // GUARDAR
    @PostMapping
    public ResponseEntity<Mueble> guardar(@RequestBody Mueble mueble) {
        Mueble nuevoMueble = muebleService.guardar(mueble);
        return new ResponseEntity<>(nuevoMueble, HttpStatus.CREATED);
    }

    // CASO ESPECIAL
    @GetMapping("/precio")
    public List<Mueble> porPrecio(@RequestParam double min, @RequestParam double max) {
        return muebleService.porPrecio(min, max);
    }
}