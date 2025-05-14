/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registropersonas;

/**
 *
 * @author piero
 */

public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;

    public Persona(String nombre, String apellido, String cedula, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Cédula: " + cedula + " - " + nombre + " " + apellido + " (Edad: " + edad + ")";
    }
}