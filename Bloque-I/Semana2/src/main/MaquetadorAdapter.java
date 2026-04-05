/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Adaptador que implementa la interfaz avanzada utilizando la lógica del maquetador básico.
 */
public class MaquetadorAdapter implements IMaquetadorAvanzado {
    
    // El adaptador contiene una instancia de la clase existente (Composición) 
    private MaquetadorBasico basico;

    public MaquetadorAdapter(MaquetadorBasico basico) {
        this.basico = basico;
    }

    @Override
    public void unirFicheros(String f1, String f2, String dest) throws IOException {
        // Leemos el contenido de ambos archivos
        String contenidoF1 = new String(Files.readAllBytes(Paths.get(f1)));
        String contenidoF2 = new String(Files.readAllBytes(Paths.get(f2)));
        
        // Delegamos en el método 'añadirTexto' del maquetador básico 
        basico.añadirTexto(dest, contenidoF1);
        basico.añadirTexto(dest, contenidoF2);
    }

    @Override
    public void combinarFicheros(String f1, String f2, String dest, List<int[]> rangos) throws IOException {
        for (int[] r : rangos) {
            // Extraemos párrafos usando el método útil del básico
            String parrafo1 = basico.extraerParrafo(f1, r[0], r[1]);
            basico.añadirTexto(dest, parrafo1);
            
            String parrafo2 = basico.extraerParrafo(f2, r[0], r[1]);
            basico.añadirTexto(dest, parrafo2);
        }
    }

    @Override
    public void separarEnVarios(String origen, List<Integer> cortes) throws IOException {
        // Para cada punto de corte, utilizamos la lógica de división del básico 
        // En este caso, el adaptador adapta la lista de cortes para crear múltiples segmentos
        List<String> lineas = Files.readAllLines(Paths.get(origen));
        int inicio = 0;
        
        for (int i = 0; i < cortes.size(); i++) {
            int fin = cortes.get(i);
            // Lógica de adaptación para separar el contenido en bloques específicos
            String bloque = String.join(System.lineSeparator(), lineas.subList(inicio, fin));
            Files.write(Paths.get(origen + "_segmento_" + (i + 1) + ".txt"), bloque.getBytes());
            inicio = fin;
        }
    }
}