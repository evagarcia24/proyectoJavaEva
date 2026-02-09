package com.tareas.agenda.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tareas.agenda.entities.TareasEntity;
import com.tareas.agenda.exception.TareaNotFoundException;
import com.tareas.agenda.repository.TareasRepository;

@Service
public class TareasService {

    private final TareasRepository repo;

    public TareasService(TareasRepository repo) {
        this.repo = repo;
    }

    public TareasEntity crear(TareasEntity tarea) {
        if (tarea.getTitulo() == null || tarea.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        tarea.setRealizada(false);
        return repo.save(tarea);
    }

    public TareasEntity obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new TareaNotFoundException(id));
    }

    public List<TareasEntity> listar() {
        return repo.findAll();
    }

    public TareasEntity actualizar(Long id, TareasEntity datos) {
        TareasEntity existente = obtener(id);

        if (datos.getTitulo() != null && !datos.getTitulo().trim().isEmpty()) {
            existente.setTitulo(datos.getTitulo());
        }

        existente.setRealizada(datos.isRealizada());
        existente.setVencimiento(datos.getVencimiento());

        return repo.save(existente);
    }

    public TareasEntity marcarRealizada(Long id, boolean realizada) {
        TareasEntity tarea = obtener(id);
        tarea.setRealizada(realizada);
        return repo.save(tarea);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new TareaNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
