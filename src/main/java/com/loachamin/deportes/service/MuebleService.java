package com.loachamin.deportes.service;

import com.loachamin.deportes.model.Mueble;
import com.loachamin.deportes.repository.MuebleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MuebleService {

    private MuebleRepository muebleRepository;

    public MuebleService(MuebleRepository muebleRepository) {
        this.muebleRepository = muebleRepository;
    }

    // TRAER TODOS
    public List<Mueble> traerTodos() {
        return muebleRepository.findAll();
    }

    // GUARDAR
    public Mueble guardar(Mueble mueble) {
        return muebleRepository.save(mueble);
    }

    // CASO ESPECIAL: Filtrar por rango de precio
    public List<Mueble> porPrecio(double min, double max) {
        return muebleRepository.findAll()
                .stream()
                .filter(m -> m.getPrecio() >= min && m.getPrecio() <= max)
                .collect(Collectors.toList());
    }
}