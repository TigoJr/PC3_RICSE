/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Administrador
 */
import model.*;
import factory.UsuarioFactory;
import command.*;
import history.Historial;
import controller.Administrador;

public class Principal {
    public static void main(String[] args) {

        Tutor tutor1 = (Tutor) UsuarioFactory.crearUsuario("tutor", "T01", "Carlos");
        Tutor tutor2 = (Tutor) UsuarioFactory.crearUsuario("tutor", "T02", "Lucia");
        Estudiante estudiante = (Estudiante) UsuarioFactory.crearUsuario("estudiante", "E01", "Ana");

        System.out.println("Usuarios creados:");
        System.out.println("Tutor 1: " + tutor1.getNombre());
        System.out.println("Tutor 2: " + tutor2.getNombre());
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println();

        Tutoria tutoria = new Tutoria(tutor1, estudiante, "2025-07-05");

        Administrador admin = new Administrador("Admin1");
        Historial historial = new Historial();

        Command asignarTutorCmd = new AsignarTutorCommand(tutoria, tutor2, historial);
        Command reprogramarSesionCmd = new ReprogramarSesionCommand(tutoria, "2025-07-10", historial);
        Command suspenderTutoriaCmd = new SuspenderTutoriaCommand(tutoria, historial);

        System.out.println("--- Ejecutando comandos ---");
        admin.ejecutarComando(asignarTutorCmd);
        admin.ejecutarComando(reprogramarSesionCmd);
        admin.ejecutarComando(suspenderTutoriaCmd);
        System.out.println();

        System.out.println("--- Deshaciendo últimos cambios ---");
        suspenderTutoriaCmd.undo();
        reprogramarSesionCmd.undo();
        asignarTutorCmd.undo();

        System.out.println();

        System.out.println("--- Cambiando estados de la tutoría ---");
        tutoria.aceptar();
        tutoria.completar();

        System.out.println();

        System.out.println("Estado final de la tutoría: " + tutoria.estado.getEstado());
    }
}
