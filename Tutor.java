/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrador
 */
public class Tutor extends Usuario {
    public Tutor(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public String getTipo() {
        return "Tutor";
    }
}
