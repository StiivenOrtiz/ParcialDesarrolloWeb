package com.st1ven11.parcial.services;

import com.st1ven11.parcial.models.BibliotecaStiven;
import com.st1ven11.parcial.models.LibroStiven;
import com.st1ven11.parcial.repositories.BibliotecaStivenRepository;
import com.st1ven11.parcial.repositories.LibroStivenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroStivenService {

    private final BibliotecaStivenRepository bibliotecaRepository;
    private final LibroStivenRepository libroRepository;

    @Autowired
    public LibroStivenService(BibliotecaStivenRepository bibliotecaRepository, LibroStivenRepository libroRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.libroRepository = libroRepository;
    }

    public List<LibroStiven> getAllLibros() {
        return libroRepository.findAll();
    }

    public Optional<LibroStiven> getLibroById(Long id) {
        return libroRepository.findById(id);
    }

    public LibroStiven createLibro(LibroStiven libro) {
        return libroRepository.save(libro);
    }

    public LibroStiven updateLibro(Long id, LibroStiven updatedLibro) {
        if (libroRepository.existsById(id)) {
            updatedLibro.setId(id);
            return libroRepository.save(updatedLibro);
        }
        return null;
    }

    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public Optional<BibliotecaStiven> getBibliotecaById(Long bibliotecaId) {
        return bibliotecaRepository.findById(bibliotecaId);
    }
}
