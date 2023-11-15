package com.st1ven11.parcial.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.net.ssl.SSLSession;

@Getter
@Data
@AllArgsConstructor
@Setter
public class LibroStivenDTO {
    private Long id;
    private String nombre;
    private String autor;
    private Long bibliotecaId;
    private String bibliotecaNombre;

    public LibroStivenDTO() {

    }

    public LibroStivenDTO(Long id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
    }
}
