/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import history.Historial;
import model.EstadoTutoria;
import model.Tutoria;

/**
 *
 * @author Administrador
 */
public class SuspenderTutoriaCommand implements Command {
    private Tutoria tutoria;
    private EstadoTutoria estadoAnterior;
    private Historial historial;

    public SuspenderTutoriaCommand(Tutoria tutoria, Historial historial) {
        this.tutoria = tutoria;
        this.historial = historial;
        this.estadoAnterior = tutoria.estado;
    }

    @Override
    public void execute() {
        tutoria.suspenderTutoria();
    }

    @Override
    public void undo() {
        tutoria.setEstado(estadoAnterior);
        tutoria.notificador.notificar("Tutoría suspendida revertida, estado: " + estadoAnterior.getEstado());
    }
}