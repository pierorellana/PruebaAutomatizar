/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registropersonas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author piero
 */

public class RegistroPersonas {
    private List<Persona> listaPersonas;

    public RegistroPersonas() {
        this.listaPersonas = new ArrayList<>();
    }

    public void registrarPersona(String nombre, String apellido, String cedula, int edad) {
        Persona persona = new Persona(nombre, apellido, cedula, edad);
        listaPersonas.add(persona);
    }

    public List<Persona> obtenerPersonas() {
        return listaPersonas;
    }
}