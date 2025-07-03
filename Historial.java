/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package history;

/**
 *
 * @author Administrador
 */
import java.util.Stack;
import model.Tutoria;
import model.TutoriaMemento;

public class Historial {
    private Stack<TutoriaMemento> mementos = new Stack<>();

    public void guardar(Tutoria tutoria) {
        mementos.push(tutoria.crearMemento());
    }

    public void deshacer(Tutoria tutoria) {
        if (!mementos.isEmpty()) {
            TutoriaMemento memento = mementos.pop();
            tutoria.restaurarMemento(memento);
        } else {
            System.out.println("No hay estados anteriores para restaurar.");
        }
    }
}
