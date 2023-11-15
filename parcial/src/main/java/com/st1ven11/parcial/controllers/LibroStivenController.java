package com.st1ven11.parcial.controllers;

import com.st1ven11.parcial.DTOs.LibroStivenDTO;
import com.st1ven11.parcial.models.BibliotecaStiven;
import com.st1ven11.parcial.models.LibroStiven;
import com.st1ven11.parcial.services.LibroStivenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

        //        // imprimir la lista de libros;
//        lista.forEach(libroStiven -> System.out.println(libroStiven.toString()));
//
//        // Filtrar los libros que tienen biblioteca no nula
//        List<LibroStiven> librosConBiblioteca = lista.stream()
//                .filter(libro -> libro.getBiblioteca() != null)
//                .toList();
//
//        librosConBiblioteca.forEach(libroStiven -> System.out.println(libroStiven.toString()));
//
//
//        // Obtener la información básica de cada libro
//        List<LibroStivenDTO> librosDTO = librosConBiblioteca.stream().map(libro -> new LibroStivenDTO(
//                libro.getId(),
//                libro.getNombre(),
//                libro.getAutor(),
//                libro.getBiblioteca().getId(),
//                ""
//        )).collect(Collectors.toList());
//
//        // Obtener la información de la biblioteca correspondiente para cada libro
//        Map<Long, BibliotecaStiven> bibliotecasMap = librosConBiblioteca.stream()
//                .collect(Collectors.toMap(
//                        libro -> libro.getBiblioteca().getId(),
//                        LibroStiven::getBiblioteca,
//                        (existing, replacement) -> existing
//                ));
//
//        // Agregar la información de la biblioteca a cada libro
//        librosDTO.forEach(libroDTO -> {
//            BibliotecaStiven biblioteca = bibliotecasMap.get(libroDTO.getBibliotecaId());
//            if (biblioteca != null) {
//                libroDTO.setBibliotecaNombre(biblioteca.getNombre());
//            }
//        });
//
//        librosDTO.forEach(libroStivenDTO -> System.out.println(libroStivenDTO.toString()));

        // imprimir la lista de libros;
        lista.forEach(libroStiven -> System.out.println(libroStiven.toString()));

        return lista.stream().map(libro -> new LibroStivenDTO(
                libro.getId(),
                libro.getNombre(),
                libro.getAutor()
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

                                value.getBiblioteca().getId(),
                                value.getBiblioteca().getNombre()
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
                    createdLibro.getAutor()
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Otros métodos para actualizar y eliminar libros

}
