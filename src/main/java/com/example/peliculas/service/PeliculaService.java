package com.example.peliculas.service;

import com.example.peliculas.entity.PeliculaEntity;
import com.example.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<PeliculaEntity> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public Optional<PeliculaEntity> buscarPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    public PeliculaEntity guardarPelicula(PeliculaEntity pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public PeliculaEntity actualizarPelicula(Long id, PeliculaEntity pelicula) {

        PeliculaEntity peliculaActual = peliculaRepository.findById(id).orElse(null);

        if (peliculaActual != null) {

            peliculaActual.setTitulo(pelicula.getTitulo());
            peliculaActual.setDirector(pelicula.getDirector());
            peliculaActual.setAnioLanzamiento(
                    pelicula.getAnioLanzamiento());
            peliculaActual.setGenero(pelicula.getGenero());
            peliculaActual.setSinopsis(pelicula.getSinopsis());

            return peliculaRepository.save(peliculaActual);
        }

        return null;
    }

    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}