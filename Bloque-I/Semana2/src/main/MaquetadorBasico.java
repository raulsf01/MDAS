/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class MaquetadorBasico {

    // 1) Añadir texto al final de un archivo 
    public void añadirTexto(String path, String texto) throws IOException {
        Files.write(Paths.get(path), (texto + System.lineSeparator()).getBytes(), 
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    // 2) Extraer un párrafo (línea inicio a fin) 
    public String extraerParrafo(String path, int inicio, int fin) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(path));
        // Ajuste de índice 1-based a 0-based
        return lineas.subList(inicio - 1, Math.min(fin, lineas.size()))
                     .stream().collect(Collectors.joining(System.lineSeparator()));
    }

    // 3) Dividir un fichero en dos por una línea de corte
    public void dividirFichero(String path, int corte) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(path));
        String parte1 = lineas.subList(0, corte).stream().collect(Collectors.joining(System.lineSeparator()));
        String parte2 = lineas.subList(corte, lineas.size()).stream().collect(Collectors.joining(System.lineSeparator()));
        
        Files.write(Paths.get(path + "_parte1.txt"), parte1.getBytes());
        Files.write(Paths.get(path + "_parte2.txt"), parte2.getBytes());
    }
}