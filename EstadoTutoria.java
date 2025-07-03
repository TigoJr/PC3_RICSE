/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrador
 */
public interface EstadoTutoria {
    void aceptar(Tutoria tutoria);
    void rechazar(Tutoria tutoria);
    void completar(Tutoria tutoria);
    String getEstado();
}