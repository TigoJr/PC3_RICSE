/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import model.Usuario;

/**
 *
 * @author Administrador
 */
public class UsuarioObserver implements Observer {
    private Usuario usuario;

    public UsuarioObserver(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void update(String mensaje) {
        System.out.println("Notificación para " + usuario.getTipo() + " " + usuario.getNombre() + ": " + mensaje);
    }
}