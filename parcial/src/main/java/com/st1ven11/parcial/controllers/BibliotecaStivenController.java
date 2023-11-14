package com.st1ven11.parcial.controllers;

import com.st1ven11.parcial.DTOs.BibliotecaStivenDTO;
import com.st1ven11.parcial.models.BibliotecaStiven;
import com.st1ven11.parcial.services.BibliotecaStivenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bibliotecas")
public class BibliotecaStivenController {

    private final BibliotecaStivenService bibliotecaService;

    @Autowired
    public BibliotecaStivenController(BibliotecaStivenService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping("/getAll")
    public List<BibliotecaStivenDTO> getAllBibliotecas() {
        List<BibliotecaStivenDTO> lista = bibliotecaService.getAllBibliotecas();
        return lista.stream().map(biblioteca -> new BibliotecaStivenDTO(
                biblioteca.getId(),
                biblioteca.getNombre(),
                biblioteca.getDireccion(),
                biblioteca.getCiudad()
        )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaStivenDTO> getBibliotecaById(@PathVariable Long id) {
        Optional<BibliotecaStiven> biblioteca = bibliotecaService.getBibliotecaById(id);
        return biblioteca.map(value -> ResponseEntity.ok(
                new BibliotecaStivenDTO(
                        value.getId(),
                        value.getNombre(),
                        value.getDireccion(),
                        value.getCiudad()
                )
                ))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<BibliotecaStivenDTO> createBiblioteca(@RequestBody BibliotecaStivenDTO bibliotecaDTO) {
        try {
            BibliotecaStiven biblioteca = new BibliotecaStiven(
                    bibliotecaDTO.getNombre(),
                    bibliotecaDTO.getDireccion(),
                    bibliotecaDTO.getCiudad()
            );
            BibliotecaStiven createdBiblioteca = bibliotecaService.createBiblioteca(biblioteca);
            return ResponseEntity.ok(new BibliotecaStivenDTO(
                    createdBiblioteca.getId(),
                    createdBiblioteca.getNombre(),
                    createdBiblioteca.getDireccion(),
                    createdBiblioteca.getCiudad()
            ));
        } catch (Exception e) {
            // Loguea la excepción para obtener más detalles
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<BibliotecaStivenDTO> updateBiblioteca(@PathVariable Long id, @RequestBody BibliotecaStivenDTO updatedBibliotecaDTO) {
        BibliotecaStiven updatedBiblioteca = new BibliotecaStiven(
                updatedBibliotecaDTO.getId(),
                updatedBibliotecaDTO.getNombre(),
                updatedBibliotecaDTO.getDireccion(),
                updatedBibliotecaDTO.getCiudad()
        );
        BibliotecaStiven biblioteca = bibliotecaService.updateBiblioteca(id, updatedBiblioteca);
        if (biblioteca != null) {
            return ResponseEntity.ok(new BibliotecaStivenDTO(
                    biblioteca.getId(),
                    biblioteca.getNombre(),
                    biblioteca.getDireccion(),
                    biblioteca.getCiudad()
            ));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBiblioteca(@PathVariable Long id) {
        bibliotecaService.deleteBiblioteca(id);
        return ResponseEntity.noContent().build();
    }
}
