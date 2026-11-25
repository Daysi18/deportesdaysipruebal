package com.loachamin.deportes.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String equipo;
    private String posicion;
    private int edad;
    private int goles;
}