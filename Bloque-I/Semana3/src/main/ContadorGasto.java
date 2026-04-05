package main;

/**
 * Interfaz que define el comportamiento común para aparatos y espacios
 */
public interface ContadorGasto {
    double calcularGasto(); // Calcula el coste en base a la estimación 
    String getNombre();
}
