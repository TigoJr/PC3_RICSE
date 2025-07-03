/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.Estudiante;
import model.Tutor;
import model.Usuario;

/**
 *
 * @author Administrador
 */
public class UsuarioFactory {
    public static Usuario crearUsuario(String tipo, String id, String nombre) {
        switch (tipo.toLowerCase()) {
            case "tutor" -> {
                return new Tutor(id, nombre);
            }
            case "estudiante" -> {
                return new Estudiante(id, nombre);
            }
            default -> throw new IllegalArgumentException("Tipo de usuario no válido");
        }
    }
}
