package com.loachamin.deportes.service;

import com.loachamin.deportes.model.Vuelo;
import com.loachamin.deportes.repository.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VueloService {

    private VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    // TRAER TODOS
    public List<Vuelo> traerTodos() {
        return vueloRepository.findAll();
    }

    // GUARDAR
    public Vuelo guardar(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    // CASO ESPECIAL: Filtrar por destino
    public List<Vuelo> porDestino(String destino) {
        return vueloRepository.findAll()
                .stream()
                .filter(v -> v.getDestino().equalsIgnoreCase(destino))
                .collect(Collectors.toList());
    }
}