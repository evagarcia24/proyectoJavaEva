package com.tareas.agenda.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tareas.agenda.entities.TareasEntity;
import com.tareas.agenda.services.TareasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tareas")
public class TareasController {

	private final TareasService service;

	public TareasController(TareasService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<TareasEntity> crear(
			@Valid @RequestBody TareasEntity tarea) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.crear(tarea));
	}

	@GetMapping("/{id}")
	public TareasEntity obtener(@PathVariable Long id) {
		return service.obtener(id);
	}

	@GetMapping
	public List<TareasEntity> listar() {
		return service.listar();
	}

	@PutMapping("/{id}")
	public TareasEntity actualizar(@PathVariable Long id,
			@Valid @RequestBody TareasEntity tarea) {
		return service.actualizar(id, tarea);
	}

	@PatchMapping("/{id}/realizada")
	public TareasEntity marcarRealizada(@PathVariable Long id,
			@RequestParam boolean realizada) {
		return service.marcarRealizada(id, realizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		service.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
