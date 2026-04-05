package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase base para Campus, Edificios y Salas que contienen otros elementos
 */
public abstract class EspacioCompuesto implements ContadorGasto {
    protected String nombre;
    protected List<ContadorGasto> elementos = new ArrayList<>(); // Agregación de componentes
    public EspacioCompuesto(String nombre) {
        this.nombre = nombre;
    }

    public void añadir(ContadorGasto c) {
        elementos.add(c);
    }

    @Override
    public double calcularGasto() {
        double total = 0;
        // Calcula el gasto acumulado recorriendo todos sus componentes 
        for (ContadorGasto e : elementos) {
            total += e.calcularGasto();
        }
        return total;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

// Clases específicas para mayor claridad en la estructura 
class Sala extends EspacioCompuesto { public Sala(String n) { super(n); } }
class Edificio extends EspacioCompuesto { public Edificio(String n) { super(n); } }
class Campus extends EspacioCompuesto { public Campus(String n) { super(n); } }
