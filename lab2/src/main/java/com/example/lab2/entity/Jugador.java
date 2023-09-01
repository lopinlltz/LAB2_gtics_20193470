package com.example.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Entity
@Table(name="jugador")
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idjugador;
    //nombre, edad, posicion, club, sleccion

    @Column(name = "nombre", nullable = false, length =45)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "posicion", nullable = false, length = 45)
    private String posicion;

    @Column(name = "club", nullable = false, length = 45)
    private String club;

    @Column(name = "idseleccion", nullable = false)
    private Integer idseleccion;

}
