/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import observer.Notificador;
import observer.UsuarioObserver;

/**
 *
 * @author Administrador
 */
public class Tutoria {
    public EstadoTutoria estado;
    private Tutor tutor;
    private Estudiante estudiante;
    private String fecha;
    public Notificador notificador;

    public Tutoria(Tutor tutor, Estudiante estudiante, String fecha) {
        this.tutor = tutor;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = new Solicitada();  // Estado inicial
        this.notificador = new Notificador();

        // Se agregan los observers para tutor y estudiante
        this.notificador.agregarObserver(new UsuarioObserver(tutor));
        this.notificador.agregarObserver(new UsuarioObserver(estudiante));
    }

    public void aceptar() {
        estado.aceptar(this);
        notificador.notificar("La tutoría con fecha " + fecha + " ha sido aceptada.");
    }

    public void rechazar() {
        estado.rechazar(this);
        notificador.notificar("La tutoría con fecha " + fecha + " ha sido rechazada.");
    }

    public void completar() {
        estado.completar(this);
        notificador.notificar("La tutoría con fecha " + fecha + " ha sido completada.");
    }

    public void setEstado(EstadoTutoria estado) {
        this.estado = estado;
        System.out.println("Estado cambiado a: " + estado.getEstado());
    }

    public String getEstado() {
        return estado.getEstado();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public void asignarTutor(Tutor nuevoTutor) {
        this.tutor = nuevoTutor;
        notificador.notificar("Tutoría ahora tiene asignado al tutor: " + nuevoTutor.getNombre());
    }

    public void reprogramarSesion(String nuevaFecha) {
        this.fecha = nuevaFecha;
        notificador.notificar("Tutoría reprogramada para la fecha: " + nuevaFecha);
    }

    public void suspenderTutoria() {
        this.estado = new Rechazada();
        notificador.notificar("Tutoría suspendida.");
    }
    
    public TutoriaMemento crearMemento() {
        return new TutoriaMemento(estado, fecha, tutor);
    }

    public void restaurarMemento(TutoriaMemento memento) {
        this.estado = memento.getEstado();
        this.fecha = memento.getFecha();
        this.tutor = memento.getTutor();

        notificador.notificar("Tutoría restaurada al estado: " + estado.getEstado()
                + ", fecha: " + fecha + ", tutor: " + tutor.getNombre());
    }
    
    public Tutor getTutor() {
        return tutor;
    }

    public String getFecha() {
        return fecha;
    }
}

class Solicitada implements EstadoTutoria {
    @Override
    public void aceptar(Tutoria tutoria) {
        tutoria.setEstado(new Aceptada());
    }

    @Override
    public void rechazar(Tutoria tutoria) {
        tutoria.setEstado(new Rechazada());
    }

    @Override
    public void completar(Tutoria tutoria) {
        System.out.println("No se puede completar una tutoría solicitada.");
    }

    @Override
    public String getEstado() {
        return "Solicitada";
    }
}

class Aceptada implements EstadoTutoria {
    @Override
    public void aceptar(Tutoria tutoria) {
        System.out.println("Ya está aceptada.");
    }

    @Override
    public void rechazar(Tutoria tutoria) {
        System.out.println("No se puede rechazar una tutoría aceptada.");
    }

    @Override
    public void completar(Tutoria tutoria) {
        tutoria.setEstado(new Completada());
    }

    @Override
    public String getEstado() {
        return "Aceptada";
    }
}

class Rechazada implements EstadoTutoria {
    @Override
    public void aceptar(Tutoria tutoria) {
        System.out.println("No se puede aceptar una tutoría rechazada.");
    }

    @Override
    public void rechazar(Tutoria tutoria) {
        System.out.println("Ya está rechazada.");
    }

    @Override
    public void completar(Tutoria tutoria) {
        System.out.println("No se puede completar una tutoría rechazada.");
    }

    @Override
    public String getEstado() {
        return "Rechazada";
    }
}

class Completada implements EstadoTutoria {
    @Override
    public void aceptar(Tutoria tutoria) {
        System.out.println("No se puede aceptar una tutoría completada.");
    }

    @Override
    public void rechazar(Tutoria tutoria) {
        System.out.println("No se puede rechazar una tutoría completada.");
    }

    @Override
    public void completar(Tutoria tutoria) {
        System.out.println("Ya está completada.");
    }

    @Override
    public String getEstado() {
        return "Completada";
    }
}
