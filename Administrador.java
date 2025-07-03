/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import command.Command;

/**
 *
 * @author Administrador
 */
public class Administrador {
    private String nombre;

    public Administrador(String nombre) {
        this.nombre = nombre;
    }

    public void ejecutarComando(Command comando) {
        comando.execute();
    }

    public String getNombre() {
        return nombre;
    }
}
