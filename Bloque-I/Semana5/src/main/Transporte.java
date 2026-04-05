package main;

import java.util.List;

class Transporte {
    String empresa, origen, destino, fecha;
    public Transporte(String e, String o, String d, String f) {
        this.empresa = e; this.origen = o; this.destino = d; this.fecha = f;
    }
    @Override
    public String toString() { return "Vuelo " + empresa + " [" + origen + " -> " + destino + "] el " + fecha; }
}
