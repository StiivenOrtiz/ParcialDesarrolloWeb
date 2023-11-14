package com.st1ven11.parcial.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.net.ssl.SSLSession;

@Getter
@AllArgsConstructor
@Setter
public class LibroStivenDTO {
    private Long id;
    private String nombre;
    private String autor;
    private Long bibliotecaId;
}
