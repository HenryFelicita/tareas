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

    @GetMapping
    public List<Tarea> listar() {
        // findAll() devuelve todas las filas de la tabla tarea.
        return tareaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarea crear(@RequestBody Tarea tarea) {
        tarea.setId(null);
        return tareaRepository.save(tarea);
    }
}
