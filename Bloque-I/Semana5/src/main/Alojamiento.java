package main;

import java.util.List;

public class Alojamiento {
    String nombre, ciudad;
    public Alojamiento(String n, String c) { this.nombre = n; this.ciudad = c; }
    @Override
    public String toString() { return "Hotel " + nombre + " en " + ciudad; }
}
