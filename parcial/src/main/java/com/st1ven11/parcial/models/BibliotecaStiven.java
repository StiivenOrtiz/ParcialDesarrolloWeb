package com.st1ven11.parcial.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BibliotecaStiven")
public class BibliotecaStiven {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "Ciudad", nullable = false)
    private String ciudad;

    // Constructor

    public BibliotecaStiven() {
        super();
    }

    public BibliotecaStiven(String nombre, String direccion, String ciudad) {
        super();
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public BibliotecaStiven(Long id, String nombre, String direccion, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
}
