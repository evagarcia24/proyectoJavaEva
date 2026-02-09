package com.tareas.agenda.exception;

public class TareaNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TareaNotFoundException(Long id) {
        super("No existe la tarea con id " + id);
    }
}

