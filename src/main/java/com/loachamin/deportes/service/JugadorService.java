package com.loachamin.deportes.service;

import com.loachamin.deportes.model.Jugador;
import com.loachamin.deportes.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    private JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    // TRAER TODOS
    public List<Jugador> traerTodos() {
        return jugadorRepository.findAll();
    }

    // TRAER UNO
    public Optional<Jugador> traerUno(int id) {
        return jugadorRepository.findById(id);
    }

    // GUARDAR
    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // EDITAR
    public Optional<Jugador> actualizar(int id, Jugador jugadorActualizado) {
        return jugadorRepository.findById(id)
                .map(jugadorExiste -> {
                    jugadorExiste.setNombre(jugadorActualizado.getNombre());
                    jugadorExiste.setEquipo(jugadorActualizado.getEquipo());
                    jugadorExiste.setPosicion(jugadorActualizado.getPosicion());
                    jugadorExiste.setEdad(jugadorActualizado.getEdad());
                    jugadorExiste.setGoles(jugadorActualizado.getGoles());
                    return jugadorRepository.save(jugadorExiste);
                });
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        if (jugadorRepository.existsById(id)) {
            jugadorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // CASO ESPECIAL: Total de goles
    public int golesTotales() {
        return jugadorRepository.findAll()
                .stream()
                .mapToInt(Jugador::getGoles)
                .sum();
    }
}