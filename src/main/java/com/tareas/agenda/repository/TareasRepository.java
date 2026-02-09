package com.tareas.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tareas.agenda.entities.TareasEntity;

public interface TareasRepository extends JpaRepository<TareasEntity, Long> {
}
