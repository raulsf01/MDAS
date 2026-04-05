package main;

import java.util.List;

public class Actividad {
    String nombre, fecha;
    public Actividad(String n, String f) { this.nombre = n; this.fecha = f; }
    @Override
    public String toString() { return "Actividad: " + nombre + " (" + fecha + ")"; }
}
