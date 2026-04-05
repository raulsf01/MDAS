package main;

import java.util.*;

public class SistemaTransporte {
    public List<Transporte> buscarVuelos(String origen, String destino, String fecha) {
        // Simulación de búsqueda en base de datos o listas 
        return Arrays.asList(new Transporte("Iberia", origen, destino, fecha));
    }
}
