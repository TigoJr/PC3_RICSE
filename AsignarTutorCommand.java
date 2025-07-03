/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import history.Historial;
import model.Tutor;
import model.Tutoria;

/**
 *
 * @author Administrador
 */
// Comando para asignar tutor
public class AsignarTutorCommand implements Command {
    private Tutoria tutoria;
    private Tutor nuevoTutor;
    private Tutor tutorAnterior;
    private Historial historial;

    public AsignarTutorCommand(Tutoria tutoria, Tutor nuevoTutor, Historial historial) {
        this.tutoria = tutoria;
        this.nuevoTutor = nuevoTutor;
        this.historial = historial;
        this.tutorAnterior = tutoria.getTutor();
    }

    @Override
    public void execute() {
        tutoria.asignarTutor(nuevoTutor);
    }

    @Override
    public void undo() {
        tutoria.asignarTutor(tutorAnterior);
    }
}