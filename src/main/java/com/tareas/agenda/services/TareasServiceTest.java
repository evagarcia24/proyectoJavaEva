package com.tareas.agenda.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.tareas.agenda.entities.TareasEntity;
import com.tareas.agenda.exception.TareaNotFoundException;
import com.tareas.agenda.repository.TareasRepository;

class TareasServiceTest {

    @Mock
    private TareasRepository repo;

    @InjectMocks
    private TareasService service;

    public TareasServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearTareaOk() {
        TareasEntity t = new TareasEntity("Test", false, null);
        when(repo.save(any())).thenReturn(new TareasEntity("Test", false, null));

        TareasEntity result = service.crear(t);

        assertEquals("Test", result.getTitulo());
        assertFalse(result.isRealizada());
    }

    @Test
    void crearTareaTituloVacio() {
        TareasEntity t = new TareasEntity("   ", false, null);
        assertThrows(IllegalArgumentException.class, () -> service.crear(t));
    }

    @Test
    void obtenerExistente() {
        TareasEntity t = new TareasEntity("Test", false, null);
        when(repo.findById(1L)).thenReturn(Optional.of(t));

        assertNotNull(service.obtener(1L));
    }

    @Test
    void obtenerInexistente() {
        when(repo.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TareaNotFoundException.class, () -> service.obtener(1L));
    }
}
