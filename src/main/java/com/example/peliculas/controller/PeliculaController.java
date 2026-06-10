package com.example.peliculas.controller;

import com.example.peliculas.entity.PeliculaEntity;
import com.example.peliculas.service.PeliculaService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
@Tag(name = "Películas", description = "Operaciones CRUD para la gestión de películas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<PeliculaEntity> listarPeliculas() {
        return peliculaService.listarPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<PeliculaEntity> buscarPorId(
            @PathVariable Long id) {

        return peliculaService.buscarPorId(id);
    }

    @PostMapping
    public PeliculaEntity guardarPelicula(
            @RequestBody PeliculaEntity pelicula) {

        return peliculaService.guardarPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public PeliculaEntity actualizarPelicula(
            @PathVariable Long id,
            @RequestBody PeliculaEntity pelicula) {

        return peliculaService.actualizarPelicula(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public String eliminarPelicula(
            @PathVariable Long id) {

        peliculaService.eliminarPelicula(id);

        return "Película eliminada correctamente";
    }
}