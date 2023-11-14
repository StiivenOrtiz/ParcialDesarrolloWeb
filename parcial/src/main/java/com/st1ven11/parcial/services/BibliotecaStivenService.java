package com.st1ven11.parcial.services;

import com.st1ven11.parcial.DTOs.BibliotecaStivenDTO;
import com.st1ven11.parcial.models.BibliotecaStiven;
import com.st1ven11.parcial.repositories.BibliotecaStivenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaStivenService {

    private final BibliotecaStivenRepository bibliotecaRepository;

    @Autowired
    public BibliotecaStivenService(BibliotecaStivenRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public List<BibliotecaStivenDTO> getAllBibliotecas() {
        List<BibliotecaStiven> lista = bibliotecaRepository.findAll();
        return lista.stream().map(biblioteca -> new BibliotecaStivenDTO(
                biblioteca.getId(),
                biblioteca.getNombre(),
                biblioteca.getDireccion(),
                biblioteca.getCiudad()
        )).toList();
    }

    public Optional<BibliotecaStiven> getBibliotecaById(Long id) {
        return bibliotecaRepository.findById(id);
    }

    public BibliotecaStiven createBiblioteca(BibliotecaStiven biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public BibliotecaStiven updateBiblioteca(Long id, BibliotecaStiven updatedBiblioteca) {
        if (bibliotecaRepository.existsById(id)) {
            updatedBiblioteca.setId(id);
            return bibliotecaRepository.save(updatedBiblioteca);
        }
        return null;
    }

    public void deleteBiblioteca(Long id) {
        bibliotecaRepository.deleteById(id);
    }
}
