package com.st1ven11.parcial.controllers;

import com.st1ven11.parcial.DTOs.LibroStivenDTO;
import com.st1ven11.parcial.models.LibroStiven;
import com.st1ven11.parcial.services.LibroStivenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libros")
public class LibroStivenController {

    private final LibroStivenService libroService;

    @Autowired
    public LibroStivenController(LibroStivenService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/getAll")
    public List<LibroStivenDTO> getAllLibros() {
        List<LibroStiven> lista = libroService.getAllLibros();
        return lista.stream().map(libro -> new LibroStivenDTO(
                libro.getId(),
                libro.getNombre(),
                libro.getAutor(),
                libro.getId()
        )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroStivenDTO> getLibroById(@PathVariable Long id) {
        Optional<LibroStiven> libro = libroService.getLibroById(id);
        return libro.map(value -> ResponseEntity.ok(
                        new LibroStivenDTO(
                                value.getId(),
                                value.getNombre(),
                                value.getAutor(),
                                value.getBiblioteca().getId() // Cambia esto según la estructura de tu DTO
                        )
                ))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<LibroStivenDTO> createLibro(@RequestBody LibroStivenDTO libroDTO) {
        try {
            LibroStiven libro = new LibroStiven(
                    libroDTO.getNombre(),
                    libroDTO.getAutor(),
                    libroService.getBibliotecaById(libroDTO.getBibliotecaId()).orElse(null)
            );
            LibroStiven createdLibro = libroService.createLibro(libro);
            return ResponseEntity.ok(new LibroStivenDTO(
                    createdLibro.getId(),
                    createdLibro.getNombre(),
                    createdLibro.getAutor(),
                    createdLibro.getBiblioteca().getId() // Cambia esto según la estructura de tu DTO
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Otros métodos para actualizar y eliminar libros

}
