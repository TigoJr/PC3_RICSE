/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrador
 */
public class TutoriaMemento {
    private EstadoTutoria estado;
    private String fecha;
    private Tutor tutor;

    public TutoriaMemento(EstadoTutoria estado, String fecha, Tutor tutor) {
        this.estado = estado;
        this.fecha = fecha;
        this.tutor = tutor;
    }

    public EstadoTutoria getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }

    public Tutor getTutor() {
        return tutor;
    }
}

