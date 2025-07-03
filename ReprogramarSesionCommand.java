/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import history.Historial;
import model.Tutoria;

/**
 *
 * @author Administrador
 */
public class ReprogramarSesionCommand implements Command {
    private Tutoria tutoria;
    private String nuevaFecha;
    private String fechaAnterior;
    private Historial historial;

    public ReprogramarSesionCommand(Tutoria tutoria, String nuevaFecha, Historial historial) {
        this.tutoria = tutoria;
        this.nuevaFecha = nuevaFecha;
        this.fechaAnterior = tutoria.getFecha();
        this.historial = historial;
    }

    @Override
    public void execute() {
        tutoria.reprogramarSesion(nuevaFecha);
    }

    @Override
    public void undo() {
        tutoria.reprogramarSesion(fechaAnterior);
    }
}
