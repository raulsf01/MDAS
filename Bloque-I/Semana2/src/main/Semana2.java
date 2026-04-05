/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Semana2 {
    public static void main(String[] args) {
        try {
            // Preparar archivos de prueba
            Files.write(Paths.get("doc1.txt"), "Linea 1-A\nLinea 2-A\nLinea 3-A".getBytes());
            Files.write(Paths.get("doc2.txt"), "Linea 1-B\nLinea 2-B\nLinea 3-B".getBytes());

            MaquetadorBasico basico = new MaquetadorBasico();
            IMaquetadorAvanzado maquetador = new MaquetadorAdapter(basico);

            System.out.println("--- Ejecutando Maquetación Avanzada ---");

            // Prueba 1: Unir
            maquetador.unirFicheros("doc1.txt", "doc2.txt", "unido.txt");
            System.out.println("1. Archivos unidos en 'unido.txt'");

            // Prueba 2: Combinar intercalado (Rango líneas 1 a 2)
            maquetador.combinarFicheros("doc1.txt", "doc2.txt", "combinado.txt", Arrays.asList(new int[]{1, 2}));
            System.out.println("2. Párrafos combinados en 'combinado.txt'");

            // Prueba 3: Separar en varios (Corte en línea 1 y 2)
            maquetador.separarEnVarios("doc1.txt", Arrays.asList(1, 2));
            System.out.println("3. Fichero separado en segmentos.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
