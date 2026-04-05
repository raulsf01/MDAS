package main;

/**
 * Clase que representa un aparato individual (vending, PC, etc.)
 */
public class AparatoElectrico implements ContadorGasto {
    private String nombre;
    private double consumoHora; // Consumo en kWh 
    private double horasUso;    // Horas estimadas de uso 
    private static final double PRECIO_KWH = 0.15; // Coste por kWh

    public AparatoElectrico(String nombre, double consumoHora, double horasUso) {
        this.nombre = nombre;
        this.consumoHora = consumoHora;
        this.horasUso = horasUso;
    }

    @Override
    public double calcularGasto() {
        // El gasto se estima multiplicando consumo, horas y precio 
        return consumoHora * horasUso * PRECIO_KWH;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}