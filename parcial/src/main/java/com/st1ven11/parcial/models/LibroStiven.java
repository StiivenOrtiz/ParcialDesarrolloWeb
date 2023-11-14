package com.st1ven11.parcial.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LibroStiven")
public class LibroStiven {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Autor", nullable = false)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "BibliotecaId", referencedColumnName = "id")
    private BibliotecaStiven biblioteca;

    // Constructor
    public LibroStiven() {
        super();
    }

    public LibroStiven(String nombre, String autor, BibliotecaStiven biblioteca) {
        super();
        this.nombre = nombre;
        this.autor = autor;
        this.biblioteca = biblioteca;
    }
}

