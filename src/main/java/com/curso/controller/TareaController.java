package com.curso.controller;

import com.curso.model.Tarea;
import com.curso.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@RequiredArgsConstructor

public class TareaController {
    private final TareaRepository tareaRepository;

    public TareaController(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @GetMapping
    public List<Tarea> listar() {
        // findAll() devuelve todas las filas de la tabla tarea, sin ningún orden concreto.
        return tareaRepository.findAll();
    }

    /**
     * Guarda una tarea nueva.
     *
     * Ejemplo:
     *   POST /api/tareas  {"titulo": "Comprar café"}  →  201 y la tarea con su id
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarea crear(@RequestBody Tarea tarea) {
        // Anulamos el id recibido: save() inserta si el id es null y actualiza si existe,
        // y aquí queremos que siempre cree una tarea nueva.
        tarea.setId(null);
        return tareaRepository.save(tarea);
    }
}
