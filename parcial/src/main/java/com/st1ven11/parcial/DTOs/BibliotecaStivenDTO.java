package com.st1ven11.parcial.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BibliotecaStivenDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;
}
